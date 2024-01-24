package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper mapper;

	@Override
	public boolean isCorrectIdAndPassword(String userId, String password) throws Exception {
		
		User user = mapper.selectByUserId(userId);
		
		//ユーザーIDが正しいかチェック
		//IDが誤っているとデータ取得されない
		if(user == null) {

			return false;
		}
		
		//パスワードが正しいかチェック
		if(!BCrypt.checkpw(password, user.getPassword())) {
			return false;
			
		}
		return true;
	}

}
