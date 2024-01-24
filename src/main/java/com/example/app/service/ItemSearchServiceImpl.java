package com.example.app.service;

import java.util.List;

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
	
	// 条件検索
	@Override
	public List<Item> searchItems(Item searchForm) throws Exception {
		return itemMapper.searchItems(searchForm);
	}
	
	// 製品マスター個別の表示
	@Override
	public Item getItemByItemId(Integer itemId) throws Exception {
		return itemMapper.selectByItemId(itemId);
	}
	
	// 製品マスターの編集更新
	@Override
	public void editItem(Item item) throws Exception {
		itemMapper.update(item);
	}
	
	
	// 製品マスターの追加
	@Override
	public void addItem(Item item) throws Exception {
	    itemMapper.insert(item);
	}
	
	// 製品マスターの削除
	@Override
	public void deleteItem(Item item) throws Exception {
	itemMapper.delete(item);
	}
}
