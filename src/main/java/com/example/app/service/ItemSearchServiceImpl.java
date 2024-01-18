package com.example.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Genre;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;
import com.example.app.mapper.GenreMapper;
import com.example.app.mapper.ItemMapper;
import com.example.app.mapper.MakerMapper;
import com.example.app.mapper.ScaleMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {

	private final ItemMapper itemMapper;
	private final MakerMapper makerMapper;
	private final GenreMapper genreMapper;
	private final ScaleMapper scaleMapper;

	// 全件取得
	@Override
	public List<Item> getItemList() throws Exception {
		return itemMapper.selectAll();
	}

	// 条件検索
	// TODO 条件付き検索のときはどうするか
	@Override
	public List<Item> searchItems(String maker, String itemNo, String itemName, String genre, String scale,
			String series, String original) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("maker", maker);
		params.put("itemNo", itemNo);
		params.put("itemName", itemName);
		params.put("genre", genre);
		params.put("scale", scale);
		params.put("series", series);
		params.put("original", original);

		return itemMapper.searchItems(params);
	}

	// メーカーマスター取得
	@Override
	public List<Maker> getMakerList() throws Exception {
		return makerMapper.selectAll();
	}

	// ジャンルマスター取得
	@Override
	public List<Genre> getGenreList() throws Exception {
		return genreMapper.selectAll();

	}

	// スケールマスター取得
	@Override
	public List<Scale> getScaleList() throws Exception {
		return scaleMapper.selectAll();
	}

}
