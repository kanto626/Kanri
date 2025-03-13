package com.example.app.service;

import jakarta.servlet.http.HttpSession;

public interface AdminService {

	// 引数として渡されたログインIDとパスワードの組み合わせが正しいかを判別し、
	// 正しくない場合はfalseを返す、正しい場合はセッションに管理者氏名を格納し、trueを返す
	boolean login(String loginId,
			String loginPass,
			HttpSession session);
}
