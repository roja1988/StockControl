package com.example.app.domain;

import lombok.Data;

@Data
public class Stock {

	// 製品ID
	private Integer itemId;
	
	// エリアID
	private Integer areaId;
	
	// エリア
	private String area;
	
	// 在庫数量
	private Integer stockQuantity;
	
	// 削除フラグ
	private Integer deleteFlg;
}
