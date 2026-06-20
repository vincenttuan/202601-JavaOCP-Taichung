package model.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	
	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String role;
	private Date createTime;
	
}
