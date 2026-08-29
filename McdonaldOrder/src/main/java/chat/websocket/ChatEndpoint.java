package chat.websocket;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import chat.dao.ChatMessageDao;
import chat.dao.MemoryChatMessageDao;
import chat.model.ChatMessage;
import jakarta.websocket.CloseReason;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * 簡易版聊天室
 * */
@ServerEndpoint("/ws/chat")
public class ChatEndpoint {
	
	// 存放目前所有連線中的使用者
	private static Set<Session> sessions = new CopyOnWriteArraySet<>();
	
	// 使用記憶體 DAO, 未來可以替換成 JdbcChatMessageDao 來與資料庫連結
	// 例如: private static ChatMessageDao messageDao = new JdbcChatMessageDao();
	private static ChatMessageDao messageDao = new MemoryChatMessageDao();
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.printf("聊天室已連線, session id: %s%n", session.getId());
		
		sessions.add(session);
		
		// 將先前的訊息傳給剛加入的使用者
		messageDao.findAll().forEach(message -> session.getAsyncRemote().sendText(format(message)));
	}
	
	@OnMessage
	public void onMessage(String text, Session session) {
		System.out.printf("收到訊息:%s, session id: %s%n", text, session.getId());
		
		// 瀏覽器送來的格式:CUSTOMER|訊息 或 STAFF|訊息
		int separator = text.indexOf('|');
		if(separator == -1) {
			return;
		}
		
		String sender = text.substring(0, separator);
		String content = text.substring(separator+1).trim();
		
		if(!sender.equals("CUSTOMER") && !sender.equals("STAFF")) {
			return;
		}
		
		if(content.isEmpty()) {
			return;
		}
		
		if(content.length() > 200) {
			content = content.substring(0, 200);
		}
		
		ChatMessage message = new ChatMessage(sender, content, LocalDateTime.now());
		messageDao.save(message);
		
		// 廣播給所有使用者 send all
		sessions.forEach(s -> {
			if(s.isOpen()) {
				s.getAsyncRemote().sendText(format(message));
			}
		});
		
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.printf("聊天室已離線, session id: %s, reason: %s%n", session.getId(), reason);
		
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		System.err.printf("WebSocket 發生錯誤, session id: %s, error: %s%n", session.getId(), error);
		throw new RuntimeException("WebSocket 發生錯誤, error: " + error);
	}
	
	// 格式化 Chatmessage
	// 範例:
	// CUSTOMER|Hello   <-- 客戶發的訊息
	// STAFF|您好        <-- 客服回應的訊息
	private String format(ChatMessage message) {
		return message.getSender() + "|" + message.getContent();
	}
	
}
