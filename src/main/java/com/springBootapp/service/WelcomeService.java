package com.springBootapp.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootapp.component.WelcomeComponent;
import com.springBootapp.pojo.Greeting;
import com.springBootapp.pojo.UserGreet;

@Service
public class WelcomeService {

	@Autowired
	private WelcomeComponent wc;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	public Greeting getGreetMssg() {
		System.err.println("service called");
		
		Greeting greet=new Greeting();
		
		greet.setId(counter.incrementAndGet());
		greet.setContent(String.format(template, "welcome user"));
		/*UserGreet user=new UserGreet();
		user.setName("pavan");*/
		greet.setUser(wc.getUserData());
		
		
		return greet;
	}

}
