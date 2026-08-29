package chat.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ChatMessage {
	
	private String sender; // 訊息來自 CUSTOMER 或 STAFF
	private String content; // 訊息內容
	private LocalDateTime sendAt; // 送出時間
	
}
