package com.example.app.mapper;

import com.example.app.domain.User;

public interface UserMapper {
	
	User selectByUserId(String userId) throws Exception;

}
