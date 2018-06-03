package com.springBootapp.pojo;

public class Hello {
	
	private String title, value;

	public Hello(String title, String value) {
		//super();
		this.title = title;
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
