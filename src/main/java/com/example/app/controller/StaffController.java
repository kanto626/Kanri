package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;
import com.example.app.service.RoomService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

// 一般社員用ページと連携するコントローラ
public class StaffController {

	private final ItemService itemService;
	private final RoomService roomService;

	// 資材リスト
	@GetMapping("/") // http://localhost:8080/ にアクセスすると、index()メソッドが呼ばれる
	public String index(
			// roomId / category / page は、URLの GET パラメータから取得される
			@RequestParam(name = "roomId", defaultValue = "ALL") String roomId,
			@RequestParam(name = "category", defaultValue = "ALL") String category,
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			HttpSession session,
			Model model) {

		List<Item> itemList;
		// ページネーション（ページ数管理）用の変数
		int totalPages = 0;
		
		if (!category.equals("ALL") && !roomId.equals("ALL")) {
		    // 🔹 カテゴリ & 倉庫 両方のフィルタを適用
		    itemList = itemService.getByCategoryAndRoom(category, roomId);
		    totalPages = itemService.getTotlaPagesByCategoryAndRoom(category, roomId);
		} else if (!category.equals("ALL")) {
		    // 🔹 カテゴリのみでフィルタ
		    itemList = itemService.getByCategory(category, page);
		    totalPages = itemService.getTotalPagesByCategory(category);
		} else if (!roomId.equals("ALL")) {
		    // 🔹 倉庫のみでフィルタ
		    itemList = itemService.getByRoomIdAndPage(roomId, page);
		    totalPages = itemService.getTotlaPagesByRoomId(roomId);
		} else {
		    // 🔹 すべてのアイテムを取得
		    itemList = itemService.getByPage(page);
		    totalPages = itemService.getTotalPages();
		}


		model.addAttribute("itemList", itemList);
		model.addAttribute("roomList", roomService.getAll());
		model.addAttribute("roomId", roomId);
	    model.addAttribute("category", category);
		model.addAttribute("page", page);
		model.addAttribute("totalPages", totalPages);
		return "index";
	}

	// 資材個別表示
	@GetMapping("/show")
	public String show(
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		Item item = null;
		if (id != null) {
			item = itemService.getOneById(id);
		}

		if (item == null) {
			return "redirect:/";
		}

		model.addAttribute("item", item);
		return "show";
	}

}