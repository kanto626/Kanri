package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Admin;
import com.example.app.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final AdminMapper adminMapper;

	@Override
	public Admin login(String loginId, String loginPass) {

		Admin admin = adminMapper.selectByLoginId(loginId);

		// ログイン ID が正しいかチェック
		// ⇒ ログイン ID が正しくなければ、管理者データは取得されない
		if (admin == null) {
			return null;
		}
		
		// パスワードが正しいかチェック
		if (!BCrypt.checkpw(loginPass, admin.getLoginPass())) { 
			return null;
		}
		// ログインID・パスワードが正しい
		return admin;
	}

}
