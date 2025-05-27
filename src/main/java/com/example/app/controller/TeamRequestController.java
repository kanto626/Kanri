package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Request;
import com.example.app.service.RequestService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class TeamRequestController {
	 private final RequestService requestService;

	    // 申請フォーム表示
	    @GetMapping("/team/request")
	    public String showForm(Model model) {
	        model.addAttribute("request", new Request());
	        return "team/request-form";
	    }

	    // 申請送信処理
	    @PostMapping("/team/request")
	    public String submit(
	            @Valid Request request,
	            Errors errors,
	            HttpSession session,
	            Model model) {
	        if (errors.hasErrors()) {
	            return "team/request-form";
	        }

	        // セッションから teamId を取得して設定
	        String teamId = (String) session.getAttribute("teamId");
	        request.setTeamId(teamId);

	        requestService.create(request);
	        model.addAttribute("statusMessage", "申請しました！");
	        return "team/request-form";
	    }
	}
