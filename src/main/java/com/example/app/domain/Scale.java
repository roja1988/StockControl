package com.example.app.domain;

import lombok.Data;

/**
 * スケールマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Scale {

	// スケールID
	private int scaleId;
	
	// スケール
	private String scale;
	
	// 削除フラグ
	private int deleteFlg;
	
}
