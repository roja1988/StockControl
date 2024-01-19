package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.service.ItemSearchService;

import jakarta.validation.Valid;
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
		return "items/itemlist";
	}

	// 条件検索の実行
	@PostMapping("/search")
	public String search(@ModelAttribute("searchForm") Item searchForm, Model model) throws Exception {
		model.addAttribute("items", itemService.searchItems(searchForm));
		return "items/itemlist";
	}

	// 製品マスターの編集画面への遷移
	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer itemId, Model model) throws Exception {
		model.addAttribute("title", "製品マスター");
		model.addAttribute("item", itemService.getItemByItemId(itemId));
		model.addAttribute("maker", itemService.getMakerList());
		model.addAttribute("genre", itemService.getGenreList());
		model.addAttribute("scale", itemService.getScaleList());
		return "Items/itemedit";
	}

	// 編集更新の実行
	@PostMapping("edit/{itemId}")
	public String editPost(
			@PathVariable Integer itemId,
			@Valid Item item,
			Errors errors,
			RedirectAttributes rd,
			Model model) throws Exception {
		if(errors.hasErrors()) {
			model.addAttribute("title","製品マスター");
			model.addAttribute("maker", itemService.getMakerList());
			model.addAttribute("genre", itemService.getGenreList());
			model.addAttribute("scale", itemService.getScaleList());
			return "Items/itemedit";
		}
		
		item.setItemId(itemId); // 更新に必要な製品IDをセット
		itemService.editItem(item);
		rd.addAttribute("statusMessage", "製品マスターを更新しました。");
		return "redirect:/items";

	}

}
