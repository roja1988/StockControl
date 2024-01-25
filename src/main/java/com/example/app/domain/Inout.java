package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Inout {
	
	// 入出庫ID
	private int inoutId;
	
	// 製品ID
	private int itemId;
	
	// 入出庫数
	private Integer inoutQuantity;
	
	// 出庫元ID
	private Integer outAreaId;
	
	// 出庫元
	private String outArea;

	// 入庫先ID
	private Integer inAreaId;
	
	// 入庫先
	private String inArea;
	
	// 入出庫日時
	private LocalDateTime inoutDatetime;
	
	// 在庫数
	private Integer stockQuantity;
	
	// 登録者ID
	private String inoutUserId;
	
	// 登録者
	private String inoutUser;
	
	// 登録日時
	private LocalDateTime registerDatetime;
	
	// 削除フラグ
	private int deleteFlg;
	
	
}
