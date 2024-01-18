package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 製品マスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Item {

	// 製品ID
	@NotBlank
	private int itemId;
	
	// 型番
	@NotBlank
	@Size(max=45)
	private String modelNumber;
	
	// 製品名
	@NotBlank
	@Size(max=45)
	private String itemName;
	
	// メーカーID
	private int makerId;
	
	// ジャンルID
	private int genreId;
	
	// スケールID
	private int scaleId;
	
	// シリーズ
	@Size(max=45)
	private String series;
	
	//原作品
	@Size(max=45)
	private String original;
	
	// 価格
	private int price;
	
	// 備考
	@Size(max=100)
	private String note;
	
	// 削除フラグ
	private int deleteFlg;
	
}
