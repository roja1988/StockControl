package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Genre;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;
import com.example.app.service.ItemSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemSearchController {

	@Autowired
	public final ItemSearchService itemService;

	// 初期画面：全件検索（上限100件）の表示
	@GetMapping
	public String List(Model model) throws Exception {
		model.addAttribute("items", itemService.getItemList());
		model.addAttribute("searchForm", new Item()); // 追加: 空のItemオブジェクトを検索フォームとして渡す
	    // メーカー、ジャンル、スケール一覧を取得して画面に渡す
	    List<Maker> makerList = itemService.getMakerList();
	    model.addAttribute("makerList", makerList);
	    List<Genre> genreList = itemService.getGenreList();
	    model.addAttribute("genreList", genreList);
	    List<Scale> scaleList = itemService.getScaleList();
	    model.addAttribute("scaleList", scaleList);

		return "items/itemlist";
	}

	// 条件検索の実行
	@PostMapping("/search")
	public String search(@ModelAttribute("searchForm") Item searchForm, Model model) throws Exception {
		model.addAttribute("items", itemService.searchItems(searchForm));
	    // メーカー、ジャンル、スケール一覧を取得して画面に渡す
	    List<Maker> makerList = itemService.getMakerList();
	    model.addAttribute("makerList", makerList);
	    List<Genre> genreList = itemService.getGenreList();
	    model.addAttribute("genreList", genreList);
	    List<Scale> scaleList = itemService.getScaleList();
	    model.addAttribute("scaleList", scaleList);
		return "items/itemlist";
	}

	// 製品マスター追加登録画面の表示
	@GetMapping("/add")
	public String addGet(Model model) throws Exception {
		model.addAttribute("title", "製品マスター追加");
		model.addAttribute("item", new Item());
	    // メーカー、ジャンル、スケール一覧を取得して画面に渡す
	    List<Maker> makerList = itemService.getMakerList();
	    model.addAttribute("makerList", makerList);
	    List<Genre> genreList = itemService.getGenreList();
	    model.addAttribute("genreList", genreList);
	    List<Scale> scaleList = itemService.getScaleList();
	    model.addAttribute("scaleList", scaleList);
		return "items/itemadd";
	}

	// 「登録」ボタンが押された場合の処理
	@PostMapping("/add")
	public String addPost(@ModelAttribute("item") Item item, Model model) {
	    try {
	        // itemServiceを介してItemSearchServiceImplに新しいアイテムを登録する
	        itemService.addItem(item);
	        
	        // 登録が成功したら一覧画面にリダイレクト
	        return "redirect:/items";
	    } catch (Exception e) {
	        // エラーが発生した場合はエラーメッセージを表示
	        model.addAttribute("error", "登録に失敗しました。");
	        return "items/itemadd";
	    }
	}

	// 製品マスターの編集画面への遷移
	@GetMapping("/edit/{itemId}")
	public String editGet(@PathVariable Integer itemId, Model model) throws Exception {
	    model.addAttribute("title", "製品マスター更新");
	    model.addAttribute("item", itemService.getItemByItemId(itemId));
	    List<Maker> makerList = itemService.getMakerList();
	    model.addAttribute("makerList", makerList);
	    List<Genre> genreList = itemService.getGenreList();
	    model.addAttribute("genreList", genreList);
	    List<Scale> scaleList = itemService.getScaleList();
	    model.addAttribute("scaleList", scaleList);
	    return "items/itemedit";
	}
	
	// 製品マスターの更新（editGetで実行）
	@PostMapping("/edit/update/{itemId}")
	public String updateItemFromEditGet(@PathVariable Integer itemId, @ModelAttribute("item") Item item, Model model) {
	    try {
	        // itemIdに対応するDBのデータをフォームの内容で更新
	        itemService.editItem(item);

	        // 更新が成功したら一覧画面にリダイレクト
	        return "redirect:/items";
	    } catch (Exception e) {
	        // エラーが発生した場合はエラーメッセージを表示
	        model.addAttribute("error", "更新に失敗しました。");
	        // エラー時は再び編集画面に戻る
	        return "items/itemedit";
	    }
	}
	
	// 製品マスターの削除画面への遷移
	@GetMapping("/delete/{itemId}")
	public String deleteGet(@PathVariable Integer itemId, Model model) throws Exception {
	    model.addAttribute("title", "製品マスター削除");
	    model.addAttribute("item", itemService.getItemByItemId(itemId));
	    List<Maker> makerList = itemService.getMakerList();
	    model.addAttribute("makerList", makerList);
	    List<Genre> genreList = itemService.getGenreList();
	    model.addAttribute("genreList", genreList);
	    List<Scale> scaleList = itemService.getScaleList();
	    model.addAttribute("scaleList", scaleList);
	    return "items/itemdelete";
	}
	
	// 製品マスターの削除処理
	@PostMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable Integer itemId, Model model) {
		System.out.println("ここまで");
	    try {
	        // itemIdに対応するDBのデータを削除
	        itemService.deleteItem(itemId);

	        // 削除が成功したら一覧画面にリダイレクト
	        return "redirect:/items";
	    } catch (Exception e) {
	        // エラーが発生した場合はエラーメッセージを表示
	        model.addAttribute("error", "削除に失敗しました。");
	        // エラー時は削除画面に戻る
	        return "items/itemdelete";
	    }
	}


}
