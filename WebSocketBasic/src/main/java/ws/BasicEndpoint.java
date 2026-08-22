package ws;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.websocket.CloseReason;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * WebSocket 基礎 Echo 回應範例
 * 
 * 瀏覽器傳送甚麼文字過來, 伺服端就就把文字加上說明後傳回去
 * 例如:
 * 1.瀏覽器傳送: "Hello" 
 * 2.伺服端收到: "Hello"
 * 3.伺服端回傳: "伺服端收到: Hello " + 時間
 * 4.瀏覽器收到: "伺服端收到: Hello " + 時間
 * */
@ServerEndpoint("/ws/basic")
public class BasicEndpoint {
	
	/**
	 * 瀏覽器成功建立 WebSocket 連線時執行
	 * @throws IOException 
	 * */
	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("WebSocket 已連線, Session ID: " + session.getId());
		// 伺服器傳主動傳送一段文字給剛連線的瀏覽器
		session.getBasicRemote().sendText("伺服端: WebSocket 連線成功 !");
	}
	
	/**
	 * 伺服端收到瀏覽器訊息時執行
	 * @throws IOException 
	 * */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("收到訊息: " + message);
		// 回傳訊息給同一個瀏覽器
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		session.getBasicRemote().sendText("伺服端收到: " + message + " " + sdf.format(new Date()));
	}
	
	/**
	 * WebSocket 連線關閉時執行
	 * */
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("WebSocket 已關閉, 原因: " + reason.getReasonPhrase());
	}
	
	/**
	 * WebSocket 發生錯誤時執行
	 * */
	@OnError
	public void onError(Session session, Throwable error) {
		String sessionId = (session == null) ? "未知" : session.getId();
		System.out.println("WebSocket 發生錯誤, Session ID: " + sessionId);
		error.printStackTrace();
	}
	
}






