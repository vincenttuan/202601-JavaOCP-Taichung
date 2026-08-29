package chat.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import chat.dao.ChatMessageDao;
import chat.dao.MemoryChatMessageDao;
import chat.model.ChatMessage;
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
		sessions.add(session);
		System.out.printf("聊天室已連線, session id: %s%n", session.getId());
		
		// 將先前的訊息傳給剛加入的使用者
		messageDao.findAll().forEach(message -> session.getAsyncRemote().sendText(format(message)));
	}
	
	// 格式化 Chatmessage
	// 範例:
	// CUSTOMER|Hello   <-- 客戶發的訊息
	// STAFF|您好        <-- 客服回應的訊息
	private String format(ChatMessage message) {
		return message.getSender() + "|" + message.getContent();
	}
	
}
