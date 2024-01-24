package com.example.app.domain;

import lombok.Data;

@Data
public class Area {
	
	// エリアID
	private int areaId;
	
	// エリア名
	private String area;
	
	//削除フラグ
	private int deleteFlg;
	
}
