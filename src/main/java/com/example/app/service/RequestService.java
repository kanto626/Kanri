package com.example.app.service;

import java.util.List;

import com.example.app.domain.Request;

public interface RequestService {
	   void create(Request request); // 新しい申請の追加

	    List<Request> getAll(); // 全申請の取得（管理者用）

	    List<Request> getByTeamId(String teamId); // チームごとの申請取得

	    Request getById(int id); // 個別の申請取得

	    void updateStatus(Request request); // ステータスと返信コメントの更新
	    
	    void deleteRequestById(int id);

}
