package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Request;
import com.example.app.service.RequestService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/request")
@RequiredArgsConstructor
public class AdminRequestController {
	private final RequestService requestService;

	// 申請一覧表示
	@GetMapping
	public String index(Model model) {
		List<Request> requestList = requestService.getAll();
		model.addAttribute("requestList", requestList);
		return "admin/request-list";
	}

	// 承認 or 却下フォーム表示（詳細画面）
	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id, Model model) {
		Request request = requestService.getById(id);
		model.addAttribute("request", request);
		return "admin/request-edit";
	}

	// 承認 or 却下処理
	@PostMapping("/edit")
	public String update(@ModelAttribute Request request) {
		requestService.updateStatus(request);
		return "redirect:/admin/request";
	}

	// 削除処理
	@GetMapping("/delete")
	public String deleteRequest(
			@RequestParam(name = "id", required = false) Integer id,
			RedirectAttributes redirectAttributes) {

		if (id != null) {
			try {
				requestService.deleteRequestById(id); // 申請を削除
				redirectAttributes.addFlashAttribute("successMessage", "申請を削除しました。");
			} catch (Exception e) {
				redirectAttributes.addFlashAttribute("errorMessage", "申請の削除に失敗しました。");
			}
		}
		return "redirect:/admin/request"; // 一覧ページにリダイレクト
	}

}