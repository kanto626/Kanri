package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
// 管理者用ページと連携するコントローラー
public class AdminController {

	private final ItemService itemService;

	@GetMapping
	public String index(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("itemList", itemService.getByPage(page));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", itemService.getTotalPages());

		return ("admin/index");
	}

}
