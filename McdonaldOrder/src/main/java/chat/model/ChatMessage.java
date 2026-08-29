package chat.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ChatMessage {
	
	private String sender;
	private String content;
	private LocalDateTime sendAt;
	
}
