package ws;

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
	
	
	
}
