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
		// HTTPに特化した機能（セッション操作・URL取得など）を使うためにキャスト
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// セッションの取得
		HttpSession session = req.getSession();

		// リクエストURLを取得
		String url = req.getRequestURI();

		// 🔒ログインページは除外する（これがないとループする）
		if (url.equals("/admin/login") || url.equals("/team/login")) {
			chain.doFilter(request, response);
			return;
		}

		// 管理者認証
		// /admin で始まるページにアクセス時、セッションに adminId がない場合は、ログインページにリダイレクト
		if (url.startsWith("/admin") && session.getAttribute("adminId") == null) {
			res.sendRedirect("/admin/login");
			return;
		}

		// チーム認証
		// /team で始まるページにアクセス時、セッションに teamId がない場合は、ログインページにリダイレクト
		if (url.startsWith("/team") && session.getAttribute("teamId") == null) {
			res.sendRedirect("/team/login");
			return;
		}

		// 認証チェックをパスしたら、フィルターを通過させる
		// 「次のフィルター、または最終的なサーブレット（またはコントローラー）」に処理を渡す命令
		chain.doFilter(request, response);
	}

}