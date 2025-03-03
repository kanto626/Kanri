package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor


// 一般社員用ページと連携するコントローラ
public class StaffController {
	private final ItemService itemService;

	// 資材リスト
		@GetMapping("/")
		public String index(Model model) {
			model.addAttribute("itemList", itemService.getAll());
			return "index";
		}


		// 資材個別表示
		@GetMapping("/show")
		public String show(
				@RequestParam(name = "id", required = false) Integer id,
				Model model) {
			Item item = null;
			if(id != null) {
				item = itemService.getOneById(id);
			}

			if(item == null) {
				return "redirect:/";
			}

			model.addAttribute("item", item);
			return "show";
		}

	}