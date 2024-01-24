package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Genre;

/**
 * 在庫数量マッパー
 * @author zd2O27
 *
 */

public interface StockMapper {

	List<Genre> selectAll() throws Exception;
}
