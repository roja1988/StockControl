package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * スケールマスタードメイン
 * @author zd2O27
 *
 */

@Data
public class Scale {

	// スケールID
	@NotBlank
	private int scaleId;
	
	// スケール
	@NotBlank
	@Size(max=45)
	private String scale;
	
	// 削除フラグ
	private int deleteFlg;
	
}
