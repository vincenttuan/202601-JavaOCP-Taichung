package chat.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import chat.dao.ChatMessageDao;
import chat.dao.MemoryChatMessageDao;
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
	
	
	
}
