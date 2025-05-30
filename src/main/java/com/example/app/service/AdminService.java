package com.example.app.service;

import com.example.app.domain.Admin;

public interface AdminService {

	// 引数として渡されたログインIDとパスワードの組み合わせが正しいかを判別し、
	// 正しくない場合はnullを返す、正しい場合はAdminを返す
	Admin login(String loginId, String loginPass);
}
