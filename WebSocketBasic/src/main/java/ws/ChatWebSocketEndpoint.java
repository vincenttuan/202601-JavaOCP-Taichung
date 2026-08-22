package ws;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import jakarta.websocket.CloseReason;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * WebSocket 群聊範例
 * 
 * 每一個瀏覽器連線就是一個 Session
 * 把所有的 Session 儲存起來
 * 收到訊息後, 再把訊息傳給所有人
 * */
@ServerEndpoint("/ws/chat")
public class ChatWebSocketEndpoint {
	
	// 存放目前所有連線中的使用者(session)
	private static Set<Session> sessions = new CopyOnWriteArraySet<>();
	
	// 將訊息傳給所有人
	private void sendAll(String message) {
		for(Session session : sessions) {
			try {
				session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		sessions.add(session);
		String message = "有人加入聊天室, Session ID [ " + session.getId() + " ]";
		System.out.println(message);
		sendAll(message);
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		message = "Session ID [ " + session.getId() + " ] 說: " + message;
		System.out.println(message);
		sendAll(message);
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		sessions.remove(session);
		String message = "有人離開聊天室, Session ID [ " + session.getId() + " ]";
		System.out.println(message);
		sendAll(message);
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("WebSocket 發生錯誤");
		error.printStackTrace();
	}
	
}
