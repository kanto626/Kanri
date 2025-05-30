package com.example.app.service;

import com.example.app.domain.Team;

public interface TeamService {

	// 引数として渡されたIDとパスワードの組み合わせが正しいかを判別し、
	// 正しくない場合はnullを返す、正しい場合はteamを返す
	Team login(String id, String loginPass);
}
