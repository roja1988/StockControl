package com.example.app.service;

import java.util.List;

import com.example.app.domain.Genre;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;

public interface ItemSearchService {

	List<Item> getItemList() throws Exception;

	List<Item> searchItems(String maker, String itemNo, String itemName, String genre, String scale, String series,
			String original) throws Exception;

	List<Genre> getGenreList() throws Exception;

	List<Maker> getMakerList() throws Exception;

	List<Scale> getScaleList() throws Exception;

}
