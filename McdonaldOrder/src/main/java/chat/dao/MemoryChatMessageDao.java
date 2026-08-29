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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChatMessage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
