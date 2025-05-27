package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Request;
@Mapper
public interface RequestMapper {
    void insert(Request request);

    List<Request> selectAll(); // 全件取得（管理者用）

    List<Request> selectByTeamId(String teamId); // チーム別取得（チームの申請履歴）

    Request selectById(int id);

    void updateStatus(Request request); // status や response_note を更新

	void deleteRequestById(int id);
}
