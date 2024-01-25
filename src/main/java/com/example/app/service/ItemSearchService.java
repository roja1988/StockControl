package com.example.app.service;

import java.util.List;

import com.example.app.domain.Area;
import com.example.app.domain.Genre;
import com.example.app.domain.Inout;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;

public interface ItemSearchService {

	List<Item> getItemList() throws Exception;

	List<Genre> getGenreList() throws Exception;

	List<Maker> getMakerList() throws Exception;

	List<Scale> getScaleList() throws Exception;
	
	List<Area> getAreaList() throws Exception;
	
	List<Item> searchItems(Item searchForm) throws Exception;
	
	Item getItemByItemId(Integer itemId) throws Exception;
	
	void editItem(Item item) throws Exception;
	
	void addItem(Item item) throws Exception;
	
	void deleteItem(Item item) throws Exception;
	
	void addInout(Inout inout) throws Exception;
	
	List<Inout> getInoutList(Integer itemId) throws Exception;
	
	void addStock(Item item) throws Exception ;
	}
