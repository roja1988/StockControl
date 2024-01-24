package com.example.app.service;

public interface UserService {
	
	boolean isCorrectIdAndPassword(String userId, String password)
			throws Exception;

}
