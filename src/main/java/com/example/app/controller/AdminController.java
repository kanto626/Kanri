package com.example.app.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
// 管理者用ページと連携するコントローラー
public class AdminController {

	private final ItemService itemService;

	@GetMapping
	// Getパラメータとしてページ番号を受け取り、それを元に資材情報を取得する
	public String index(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("itemList", itemService.getByPage(page));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", itemService.getTotalPages());

		return ("admin/index");
	}

	@GetMapping("/delete")
	// 資材IDをGetパラメータとして受け取り、資材情報の削除を行う
	public String delete(
			@RequestParam(name = "id", required = false) Integer id,
			RedirectAttributes rd) { // メッセージを渡すための RedirectAttributes
		if (id != null) {
			itemService.deleteById(id);
			rd.addFlashAttribute("statusMessage", "資材情報を削除しました。");
		}
		return "redirect:/admin";
	}

	@GetMapping("/add")
	// 資材登録フォームを表示させる
	public String add(Model model) {
		Item item = new Item();
		// 初期値の設定
				item.setAmount(0);
				item.setPurchasedAt(LocalDate.now());
				model.addAttribute("item", item);
				return "admin/add";
	}
	
	@PostMapping("/add")
	// 登録フォームを通じて取得した情報に対し、バリデーションを行う。
	// 情報に不備があれば登録フォームを再表示し、問題がなければ登録処理を行う
	public String add(
			@Valid Item item,
			Errors errors,
			RedirectAttributes rd,
			Model model) {
		if(errors.hasErrors()) {
			return"admin/add";
		}
		itemService.add(item);
		rd.addFlashAttribute("statusMessage", "資材を追加しました。");
		return "redirect:/admin";
	}
}
