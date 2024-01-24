package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Item;

/**
 * 製品マスターマッパー
 * @author zd2O27
 *
 */

public interface ItemMapper {

	List<Item> selectAll() throws Exception;
	List<Item> searchItems(Item item) throws Exception;
	Item selectByItemId(Integer itemId) throws Exception;
	void insert(Item item) throws Exception;
	void update(Item item) throws Exception;
	void delete(Item item) throws Exception;
}
