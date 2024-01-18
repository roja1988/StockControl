package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * ジャンルマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Genre {
	
	// ジャンルID
	@NotBlank
	private int genreId;
	
	// ジャンル
	@NotBlank
	private String genre;
	
	// 削除フラグ
	private int deleteFlg;
}
