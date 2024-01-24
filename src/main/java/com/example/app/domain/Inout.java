package com.example.app.domain;

import lombok.Data;

@Data
public class Inout {
	
	// 入出庫ID
	private int inoutId;
	
	// 製品ID
	private int itemId;
	
	// 入出庫数
	private int inout_quantity;
	
	// 出庫エリア
	private int outArea;

	// 入庫エリア
	private int inArea;
	
	// 削除フラグ
	private int deleteFlg;
	
}
