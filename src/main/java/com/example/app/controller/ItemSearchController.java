package com.example.app.controller;

import java.util.List; // この行を追加
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Item;
import com.example.app.service.ItemSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemSearchController {

	public final ItemSearchService itemService;

	@GetMapping
	public String List(Model model) throws Exception {
		model.addAttribute("items", itemService.getItemList());
		return "items/itemlist";
	}

	@GetMapping("/items")
	public String searchItems(@RequestParam Map<String, String> params, Model model) throws Exception {
		List<Item> items = itemService.searchItems(
				params.get("maker"),
				params.get("itemNo"),
				params.get("itemName"),
				params.get("genre"),
				params.get("scale"),
				params.get("series"),
				params.get("original"));
		model.addAttribute("items", items);
		return "items";
	}
}
