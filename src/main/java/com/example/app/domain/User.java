package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザーマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class User {

	// ユーザーID
	@NotBlank
	@Size(max=10)
	private String userId;
	
	// ユーザー名
	@Size(max=30)
	private String userName;
	
	// 部署ID
	private int unitId;
	
	// パスワード
	@NotBlank
	@Size(max=20)
	private String password;
	
	// 削除フラグ
	private int deleteFlg;
}
