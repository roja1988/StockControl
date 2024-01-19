package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	// 製品ID
	@NotNull
	private int itemId;

	// 型番
	@NotBlank
	@Size(max = 45)
	private String modelNumber;

	// 製品名
	@NotBlank
	@Size(max = 45)
	private String itemName;

	// メーカーID
	private int makerId;

	// メーカー
	private String maker;

	// ジャンルID
	private int genreId;

	// ジャンルID
	private String genre;

	// スケールID
	private int scaleId;

	// スケールID
	private String scale;

	// シリーズ
	@Size(max = 45)
	private String series;

	//原作品
	@Size(max = 45)
	private String original;

	// 価格
	private int price;

	// 備考
	@Size(max = 100)
	private String note;

	// 削除フラグ
	private int deleteFlg;
	
	/*
	 * 検索フォームからの入力を受け取るためのフィールド
	 * 
	 */
    private String makerInput;
    private String itemNoInput;
    private String itemNameInput;
    private String genreInput;
    private String scaleInput;
    private String seriesInput;
    private String originalInput;
    
    // 検索フォームからの入力を受け取るための getter/setter メソッド
    // メーカー
    public String getMakerInput() {
        return makerInput;
    }

    public void setMakerInput(String makerInput) {
        this.makerInput = makerInput;
    }
    
    // 型番
    public String getItemNoInput() {
        return itemNoInput;
    }

    public void setItemNoInput(String itemNoInput) {
        this.itemNoInput = itemNoInput;
    }
    
    // 製品名
    public String getItemNameInput() {
        return itemNameInput;
    }

    public void setItemNameInput(String itemNameInput) {
        this.itemNameInput = itemNameInput;
    }
    
    // ジャンル
    public String getGenreInput() {
        return itemNameInput;
    }

    public void setGenreInput(String genreInput) {
        this.genreInput = genreInput;
    }
    
    // スケール
    public String getScaleInput() {
        return scaleInput;
    }

    public void setScaleInput(String scaleInput) {
        this.scaleInput = scaleInput;
    }
    
    // シリーズ
    public String getSeriesInput() {
        return scaleInput;
    }

    public void setSeriesInput(String seriesInput) {
        this.seriesInput = seriesInput;
    }
    
    // 原作名
    public String getOriginalInput() {
        return originalInput;
    }

    public void setOriginalInput(String originalInput) {
        this.originalInput = originalInput;
    }
    
    
}
