package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Area;
import com.example.app.domain.Genre;
import com.example.app.domain.Inout;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;
import com.example.app.domain.Stock;
import com.example.app.mapper.AreaMapper;
import com.example.app.mapper.GenreMapper;
import com.example.app.mapper.InoutMapper;
import com.example.app.mapper.ItemMapper;
import com.example.app.mapper.MakerMapper;
import com.example.app.mapper.ScaleMapper;
import com.example.app.mapper.StockMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ItemSearchServiceImpl implements ItemSearchService {

	private final ItemMapper itemMapper;
	private final MakerMapper makerMapper;
	private final GenreMapper genreMapper;
	private final ScaleMapper scaleMapper;
	private final AreaMapper areaMapper;
	private final InoutMapper inoutMapper;
	private final StockMapper stockMapper;

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

	// エリアマスター取得
	@Override
	public List<Area> getAreaList() throws Exception {
		return areaMapper.selectAll();
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
	
	// 在庫データ初期値の挿入
	@Override
	public void addStockInit(Item item) throws Exception {
		stockMapper.insert(item);
	}

	// 製品マスターの削除
	@Override
	public void deleteItem(Item item) throws Exception {
		itemMapper.delete(item);
	}

	// 入出庫データの登録
	@Override
	public void addInout(Inout inout) throws Exception {
		inoutMapper.insert(inout);
	}
	
	// 選択した製品マスターの入出庫履歴を取得
	@Override
	public List<Inout> getInoutList(Integer itemId) throws Exception {
		return inoutMapper.getInoutList(itemId);
	}
	/*
	// 入出庫時の在庫の加算
	@Override
	public void addStock(Inout inout) throws Exception {
		stockMapper.updateAdd(inout);
	}
	
	// 入出庫時の在庫の減算
	@Override
	public void subtractStock(Inout inout) throws Exception {
		stockMapper.updateSubtract(inout);
	}
	*/
	// 入出庫時の在庫の減算
	@Override
	public void addSubtractStock(Inout inout) throws Exception {
		stockMapper.updateSubtract(inout);
		stockMapper.updateAdd(inout);
	}
	
	// 在庫情報の取得
	@Override
	public List<Stock> getStock(Integer itemId) throws Exception {
		return stockMapper.select(itemId);
		
	}

	
}
