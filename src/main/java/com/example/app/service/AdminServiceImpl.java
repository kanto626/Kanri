package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Admin;
import com.example.app.mapper.AdminMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
	
	private final AdminMapper adminMapper;

	@Override
	public boolean login(String loginId, String loginPass, HttpSession session) {
		
		// 
		Admin admin = adminMapper.selectByLoginId(loginId);
		

		// ログインIDに該当する管理者がいない
		if(admin == null) {
			return false;
		}

		// パスワードが異なる
		if(!BCrypt.checkpw(loginPass, admin.getLoginPass())) {
			return false;
		}

		// ログインID・パスワードが正しい
		// ⇒ 管理者氏名をセッションに格納
		session.setAttribute("name", admin.getName());
		return true;
	}

}
