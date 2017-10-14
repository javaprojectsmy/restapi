package com.poonia.services;

import org.springframework.stereotype.Component;

@Component
public class UserWelcome {

	public String getWelcomeMessage(){
		return "hello welcome to this page";
	}
}
