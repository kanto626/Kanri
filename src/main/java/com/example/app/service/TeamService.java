package com.example.app.service;

public interface TeamService {

	// 引数として渡されたIDとパスワードの組み合わせが正しいかを判別し、
	// 正しくない場合はfalseを返す、正しい場合はセッションにチーム名を格納し、trueを返す
	boolean login(String id, String loginPass);
}
