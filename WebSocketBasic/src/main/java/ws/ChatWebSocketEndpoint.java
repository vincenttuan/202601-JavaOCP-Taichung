package ws;

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
	
	@OnOpen
	public void onOpen(Session session) {
		
	}
	
	@OnMessage
	public void onMessage(String message) {
		
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		
	}
	
}
