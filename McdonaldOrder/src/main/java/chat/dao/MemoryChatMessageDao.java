package chat.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import chat.model.ChatMessage;

public class MemoryChatMessageDao implements ChatMessageDao {
	
	private List<ChatMessage> messages = new CopyOnWriteArrayList<>();
	
	@Override
	public void save(ChatMessage message) {
		messages.add(message);
		
		// 若訊息超過 50 筆, 就陸續清除最早的資訊
		if(messages.size() > 50) {
			messages.remove(0); // 清除第一筆
		}
	}

	@Override
	public List<ChatMessage> findAll() {
		return List.copyOf(messages);
	}

}
