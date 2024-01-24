package com.example.app.domain;

import lombok.Data;

@Data
public class Stock {

	// 製品ID
	private Integer itemId;
	
	private Integer stockQuantity;
	
	private Integer deleteFlg;
}
