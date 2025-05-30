package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Admin;
import com.example.app.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LoginController {

	private final AdminService adminService;
	private final HttpSession session;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/login";
	}

	@PostMapping("/login")
	public String login(
			@Valid Admin admin, Errors errors) {
		// 入力に不備がある
		if (errors.hasErrors()) {
			return "admin/login";
		}

		String loginId = admin.getLoginId();
		String loginPass = admin.getLoginPass();

		// ログイン ID・パスワードが正しくない
		if (!adminService.login(loginId, loginPass)) {
			errors.rejectValue("loginId", "wrong_id_or_password");
			return "admin/login";
		}
		// ⇒ セッションにログイン ID を格納し、リダイレクト
		session.setAttribute("adminId", loginId);
		// ログイン成功
		return "redirect:/admin";
	}

	@GetMapping("/logout")
	public String logout() {
		// セッションを破棄し、ログインページへ遷移
		session.invalidate();
		return "redirect:/admin/login";
	}

}
