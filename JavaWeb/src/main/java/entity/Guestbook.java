package entity;

/**
 * 存放訪客留言資料
 * */
public class Guestbook {
	
	private Integer id;
	private String nickname;
	private String content;
	private String time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", nickname=" + nickname + ", content=" + content + ", time=" + time + "]";
	}
	
	
	
}
