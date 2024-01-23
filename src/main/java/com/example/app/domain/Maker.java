package com.example.app.domain;

import lombok.Data;

/**
 * メーカーマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Maker {
	
	// メーカーID
	private int makerId;
	
	// メーカー
	private String maker;
	
	// 削除フラグ
	private int deleteFlg;
}
