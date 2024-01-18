package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Maker;

/**
 * メーカーマスターマッパー
 * @author zd2O27
 *
 */

public interface MakerMapper {
	
	List<Maker> selectAll() throws Exception;

}
