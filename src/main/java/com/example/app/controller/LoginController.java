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
		} else if (!adminService.login(admin.getLoginId(), admin.getLoginPass(), session)) {
			// ログインID、またはパスワードが間違っている
			errors.rejectValue("loginId", "wrong_id_or_password");
			return "admin/login";
		}

		// ログイン成功
		return "redirect:/admin";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/admin/login";
	}

}
