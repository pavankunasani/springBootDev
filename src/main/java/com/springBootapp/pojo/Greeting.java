package com.springBootapp.pojo;

public class Greeting {

	private long id;
	private String content;

	UserGreet user;

	public Greeting(long id, String content, UserGreet user) {
		this.id = id;
		this.content = content;
		this.user = user;
	}

	public Greeting() {
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public UserGreet getUser() {
		return user;
	}

	public void setUser(UserGreet user) {
		this.user = user;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + ", user=" + user + "]";
	}
	
	

}
