package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Genre;
import com.example.app.domain.Inout;
import com.example.app.domain.Item;
import com.example.app.domain.Stock;

/**
 * 在庫数量マッパー
 * @author zd2O27
 *
 */

public interface StockMapper {

	//TODO List使ってなさそうなので、問題なければ消す。
	List<Genre> selectAll() throws Exception;
	
	void insert(Item item) throws Exception;
	/*
	void updateAdd(Inout inout) throws Exception;
	void updateSubtract(Inout inout) throws Exception;
	*/
	void updateSubtract(Inout inout) throws Exception;
	void updateAdd(Inout inout) throws Exception;
	
	List<Stock> select(Integer itemId) throws Exception;
}
