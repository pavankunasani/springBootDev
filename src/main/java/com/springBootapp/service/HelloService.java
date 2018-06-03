package com.springBootapp.service;

import org.springframework.stereotype.Service;

import com.springBootapp.pojo.Hello;

@Service
public class HelloService {
	
	
	public Hello getHelloService(){
		
		System.err.println("h service");
		
		return new Hello("hi","developer");
	}

}
