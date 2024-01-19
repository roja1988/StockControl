package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "items/itemlist";
	}
	
	@GetMapping("/items")
	public String searchItems(@ModelAttribute("item") Item item, BindingResult bindingResult, Model model) throws Exception {
	    List<Item> items = itemService.searchItems(
	        item.getMakerInput(),
	        item.getItemNoInput(),
	        item.getItemNameInput(),
	        item.getGenreInput(),
	        item.getScaleInput(),
	        item.getSeriesInput(),
	        item.getOriginalInput());

	    model.addAttribute("items", items);
	    model.addAttribute("org.springframework.validation.BindingResult.item", bindingResult); // バインディング結果をモデルに追加

	    return "items";
	}

}
