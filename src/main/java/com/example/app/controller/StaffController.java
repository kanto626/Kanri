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
	@GetMapping("/")
	public String index(
			@RequestParam(name = "roomId", defaultValue = "ALL") String roomId,
			HttpSession session,
			Model model) {

		List<Item> itemList;
		if (!roomId.equals("ALL")) {
			model.addAttribute("roomName", roomService.getNameById(roomId));
			itemList = itemService.getByRoomId(roomId);
		} else {
			itemList = itemService.getAll();
		}

		model.addAttribute("itemList", itemList);
		model.addAttribute("roomList", roomService.getAll());
		model.addAttribute("roomId", roomId);

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