package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")

// 一般社員用ページと連携するコントローラ
public class StaffController {
	private final ItemService itemService;

	@GetMapping // "/" への GET リクエストを処理
	public String index(Model model) {
		// 取得したリストをビューに渡す
		model.addAttribute("itemList", itemService.getAll());
		// index.html へフォワード
		return "index";
	}

}
