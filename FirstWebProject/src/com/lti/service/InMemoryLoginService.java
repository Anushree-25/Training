package com.lti.service;

import java.util.HashMap;
import java.util.Set;

public class InMemoryLoginService {
	
	private HashMap<String, String> users = new HashMap<>();
	
	public InMemoryLoginService() {
		users.put("anu", "1234");
		users.put("anamitra", "5678");
		users.put("polo", "1111");
		users.put("John", "2222");
	}
	
	public boolean isValidUser(String username, String password) {
		if(users.containsKey(username))
			if(users.get(username).equals(password))
				return true;
		return false;
	}
}
