package com.springBootapp.pojo;

public class UserGreet {

	private String name;

	public UserGreet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGreet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserGreet [name=" + name + "]";
	}

	
}
