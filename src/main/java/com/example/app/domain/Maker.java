package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * メーカーマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Maker {
	
	// メーカーID
	@NotBlank
	private int makerId;
	
	// メーカー
	@NotBlank
	@Size(max=45)
	private String maker;
	
	// 削除フラグ
	private int deleteFlg;
}
