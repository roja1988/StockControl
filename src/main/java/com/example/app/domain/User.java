package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

	// ユーザーID
	@NotBlank
	private String userId;
	
	// ユーザー名
	private String userName;
	
	// パスワード
	@NotBlank
	private String password;
	
	// 削除フラグ
	private int delete_flg;
}
