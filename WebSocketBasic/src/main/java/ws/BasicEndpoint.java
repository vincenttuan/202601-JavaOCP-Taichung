package ws;

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
	 * */
	@OnOpen
	
	
	/**
	 * 伺服端收到瀏覽器訊息時執行
	 * */
	@OnMessage
	
	
	/**
	 * WebSocket 連線關閉時執行
	 * */
	@OnClose
	
	
	/**
	 * WebSocket 發生錯誤時執行
	 * */
	@OnError
	
	
}






