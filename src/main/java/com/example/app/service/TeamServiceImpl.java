package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Team;
import com.example.app.mapper.TeamMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamMapper teamMapper;

	@Override
	public boolean login(String id, String loginPass, HttpSession session) {
		
		Team team = teamMapper.selectByTeamId(id);
		
		// ログインIDに該当するチームがない
		if (team == null) {
			return false;
		}
		// パスワードが異なる
		if (!BCrypt.checkpw(loginPass, team.getLoginPass())) {
			return false;
		}
		// ログインID・パスワードが正しい
		// ⇒ チーム名とIDをセッションに格納
		session.setAttribute("name", team.getName());
		session.setAttribute("teamId", team.getId());
		session.setAttribute("roomId", team.getRoomId());
		return true;
	}
}
