package com.springBootapp.component;

import org.springframework.stereotype.Component;

import com.springBootapp.pojo.UserGreet;

@Component
public class WelcomeComponent {

	public UserGreet getUserData() {

		return new UserGreet("pavan");
	}

}
