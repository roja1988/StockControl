package com.example.app.mapper;

import com.example.app.domain.User;

//TODO マッパークラスの実装

public interface UserMapper {
	
	User selectByUserId(String userId) throws Exception;

}
