package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Team;
import com.example.app.service.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamLoginController {

	private final TeamService teamService;
	private final HttpSession session;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("team", new Team());
		return "team/login";
	}

	@PostMapping("/login")
	public String login(
			@Valid Team team, Errors errors) {
		// 入力に不備がある
		if (errors.hasErrors()) {
			return "team/login";

		}
		String loginId = team.getId();
		String loginPass = team.getLoginPass();

		// ログイン ID・パスワードが正しくない
		if (!teamService.login(loginId, loginPass)) {
			// ログインID、またはパスワードが間違っている
			errors.rejectValue("id", "wrong_id_or_password");
			return "team/login";
		}
		session.setAttribute("teamId", loginId);
		// ログイン成功
		return "redirect:/team";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/team/login";
	}

}
