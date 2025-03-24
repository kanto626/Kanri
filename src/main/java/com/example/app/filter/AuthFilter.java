package com.example.app.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// ログイン認証チェックを行うフィルター
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String url = req.getRequestURI();

		// 🔒ログインページは除外する（これがないとループする）
		if (url.equals("/admin/login") || url.equals("/team/login")) {
			chain.doFilter(request, response);
			return;
		}

		// 管理者認証
		if (url.startsWith("/admin") && session.getAttribute("adminId") == null) {
			res.sendRedirect("/admin/login");
			return;
		}

		// チーム認証
		if (url.startsWith("/team") && session.getAttribute("teamId") == null) {
			res.sendRedirect("/team/login");
			return;
		}

		chain.doFilter(request, response);
	}

}