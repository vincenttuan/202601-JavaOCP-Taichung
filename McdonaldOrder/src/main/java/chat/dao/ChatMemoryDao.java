package chat.dao;

import java.util.List;

import chat.model.ChatMessage;

public interface ChatMemoryDao {
	
	void save(ChatMessage message); // 儲存一筆訊息
	
	List<ChatMessage> findAll(); // 取得目前訊息
	
}
