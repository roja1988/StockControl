package com.example.app.controller;

import java.util.List;

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

import com.example.app.domain.Genre;
import com.example.app.domain.Inout;
import com.example.app.domain.Item;
import com.example.app.domain.Maker;
import com.example.app.domain.Scale;
import com.example.app.service.ItemSearchService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemSearchController {
	
	
	@Autowired
	public final ItemSearchService itemService;

	public String successMsg;
	
	
	/**
	 * 初期画面：全件検索（上限200件）の表示
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public String List(Model model) throws Exception {
		model.addAttribute("items", itemService.getItemList());
		model.addAttribute("searchForm", new Item());
		setupLists(model); // リストのセットアップ
		model.getAttribute(successMsg);
		return "items/itemlist";
	}

	/**
	 * 条件検索の実行
	 * @param searchForm
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public String search(@ModelAttribute("searchForm") Item searchForm, Model model) throws Exception {
		model.addAttribute("items", itemService.searchItems(searchForm));
		setupLists(model); // リストのセットアップ
		return "items/itemlist";
	}

	/**
	 * 製品マスター追加登録画面の表示
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/add")
	public String addGet(Model model) throws Exception {
		model.addAttribute("item", new Item());
		setupLists(model); // リストのセットアップ
		return "items/itemadd";
	}

	/**
	 * 製品マスターの追加登録
	 * @param item
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/add")
	public String addPost(@Valid @ModelAttribute("item") Item item, RedirectAttributes ra, Errors errors, Model model)
			throws Exception {
		try {
			if (errors.hasErrors()) {
				// エラーがある場合、コンソールにエラーを出力
				errors.getAllErrors().forEach(error -> System.out.println(error.toString()));
			}

			// すでに製品マスターが存在していたらエラーにする
			if (itemService.countItem(item).getCount() > 0) {
				model.addAttribute("countErrorMsg", "同じメーカー・型番のメーカーが存在します。");
				setupLists(model); // リストのセットアップ
				return "items/itemadd";
			}
			itemService.addItem(item);
			itemService.addStockInit(item);
			// 登録が成功したら一覧画面にリダイレクト
			ra.addFlashAttribute("successMsg", item.getMaker() + " : " +item.getModelNumber() + " を登録しました。");
			return "redirect:/items";
		} catch (Exception e) {
			// エラーが発生した場合はエラーメッセージを表示
			model.addAttribute("error", "登録に失敗しました。");
			setupLists(model); // リストのセットアップ
			return "items/itemadd";
		}
	}

	/**
	 * 製品マスターの編集画面への遷移
	 * @param itemId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/edit/{itemId}")
	public String editGet(@PathVariable Integer itemId, Model model) throws Exception {
		model.addAttribute("item", itemService.getItemByItemId(itemId));
		setupLists(model); // リストのセットアップ
		return "items/itemedit";
	}

	/**
	 * 製品マスターの更新
	 * @param itemId
	 * @param item
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/edit/{itemId}")
	public String updateItemFromEditGet(@PathVariable Integer itemId, @ModelAttribute("item") Item item, RedirectAttributes ra, Model model)
			throws Exception {
		try {
			// itemIdに対応するDBのデータをフォームの内容で更新
			itemService.editItem(item);
			// 更新が成功したら一覧画面にリダイレクト
			ra.addFlashAttribute("successMsg", item.getMaker() + " : " +item.getModelNumber() + " を更新しました。");
			return "redirect:/items";
		} catch (Exception e) {
			// エラーが発生した場合はエラーメッセージを表示
			model.addAttribute("error", "更新に失敗しました。");
			model.addAttribute(e);
			System.out.println(e);
			// エラー時は再び編集画面に戻る
			setupLists(model); // リストのセットアップ
			return "items/itemedit";
		}

	}

	/**
	 * 製品マスターの削除画面への遷移
	 * @param itemId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/delete/{itemId}")
	public String deleteGet(@PathVariable Integer itemId, Model model) throws Exception {
		model.addAttribute("item", itemService.getItemByItemId(itemId));
		setupLists(model); // リストのセットアップ

		return "items/itemdelete";
	}

	/**
	 * 製品マスターの削除処理
	 * @param itemId
	 * @param item
	 * @param model
	 * @return
	 */
	@PostMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable Integer itemId, @ModelAttribute("item") Item item, RedirectAttributes ra, Model model ) {

		try {
			// itemIdに対応するDBのデータを削除
			itemService.deleteItem(item);
			// 削除が成功したら一覧画面にリダイレクト
			ra.addFlashAttribute("successMsg", item.getMaker() + " : " + item.getModelNumber() + " を削除しました。");
			System.out.println(item.getMaker());
			return "redirect:/items";
		} catch (Exception e) {
			// エラーが発生した場合はエラーメッセージを表示
			System.out.println(e);
			// エラー時は削除画面に戻る
			return "items/itemdelete";
		}
	}

	/**
	 * 製品の入出庫データ登録への遷移
	 * @param itemId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/inout/{itemId}")
	public String inoutGet(@PathVariable Integer itemId, Model model) throws Exception {
		model.addAttribute("item", itemService.getItemByItemId(itemId));
		model.addAttribute("inout", new Inout());
		setupLists(model); // リストのセットアップ
		return "items/inout";
	}

	/**
	 * 入出庫データの登録
	 * @param itemId
	 * @param item
	 * @param inout
	 * @param model
	 * @return
	 */
	@PostMapping("/inout/{itemId}")
	public String inoutPost(@PathVariable Integer itemId, @ModelAttribute("item") Item item, Inout inout, Model model) {
		try {
			// itemIdに対応する入出庫履歴データを登録
			itemService.addInout(inout);
			// 在庫の加減算
			itemService.addSubtractStock(inout);
			// 更新が成功したら一覧画面にリダイレクト
			return "redirect:/items/inout/{itemId}";
		} catch (Exception e) {
			// エラーが発生した場合はエラーメッセージを表示
			model.addAttribute("error", "更新に失敗しました。");
			// エラー時は再び編集画面に戻る
			return "items/inout";
		}

	}

	/**
	 * メーカー・ジャンル・スケールのリストをセット
	 * @param model
	 * @throws Exception
	 */
	private void setupLists(Model model) throws Exception {
		List<Maker> makerList = itemService.getMakerList();
		model.addAttribute("makerList", makerList);

		List<Genre> genreList = itemService.getGenreList();
		model.addAttribute("genreList", genreList);

		List<Scale> scaleList = itemService.getScaleList();
		model.addAttribute("scaleList", scaleList);
	}

}
