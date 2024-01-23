package com.example.app.domain;

import lombok.Data;

/**
 * ジャンルマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Genre {
	
	// ジャンルID
	private int genreId;
	
	// ジャンル
	private String genre;
	
	// 削除フラグ
	private int deleteFlg;
}
