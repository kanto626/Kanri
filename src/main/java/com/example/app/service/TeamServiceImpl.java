package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Team;
import com.example.app.mapper.TeamMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamMapper teamMapper;

	@Override
	public Team login(String id, String loginPass) {

		Team team = teamMapper.selectByTeamId(id);

		// ログイン ID が正しいかチェック
		// ⇒ ログイン ID が正しくなければ、チームのデータは取得されない
		if (team == null) {
			return null;
		}
		// パスワードが正しいかチェック
		if (!BCrypt.checkpw(loginPass, team.getLoginPass())) {
			return null;
		}
		// ログインID・パスワードが正しい
		return team;
	}
}
