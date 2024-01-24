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

	/**
	 * 検索結果を表示するためのフィールド
	 */
	
	// 在庫数量
	private Integer stockQuantity;
	
	// 製品ID
	private Integer itemId;

	// 型番
	@NotBlank
	@Size(max = 45)
	private String modelNumber;

	// 製品名
	@NotBlank
	@Size(max = 45)
	private String itemName;

	// メーカーID
	private Integer makerId;

	// メーカー
	private String maker;

	// ジャンルID
	private Integer genreId;

	// ジャンルID
	private String genre;

	// スケールID
	private Integer scaleId;

	// スケールID
	private String scale;

	// シリーズ
	@Size(max = 45)
	private String series;

	//原作品
	@Size(max = 45)
	private String original;

	// 価格
	private Integer price;

	// 備考
	@Size(max = 100)
	private String note;

	// 削除フラグ
	private int deleteFlg;
	
	/*
	 * 検索フォームからの入力を受け取るためのフィールド
	 * 
	 */
    private String makerIdInput;
    private String modelNumberInput;
    private String itemNameInput;
    private String genreIdInput;
    private String scaleIdInput;
    private String seriesInput;
    private String originalInput;
    private String inAreaIdInput;
    private String outAreaIdInput;

    			   
}
