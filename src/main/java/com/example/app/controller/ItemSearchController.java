package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Item;
import com.example.app.service.ItemSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemSearchController {

	@Autowired
	public final ItemSearchService itemService;

	@GetMapping
	public String List(Model model) throws Exception {
		model.addAttribute("items", itemService.getItemList());
		model.addAttribute("searchForm", new Item()); // 追加: 空のItemオブジェクトを検索フォームとして渡す
		return "items/itemlist";
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("searchForm") Item searchForm, Model model) throws Exception {
		model.addAttribute("items", itemService.searchItems(searchForm));
		return "items/itemlist";
	}


}
