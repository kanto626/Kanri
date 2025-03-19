package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Team;

@Mapper
public interface TeamMapper {
	//IDを元に、チーム情報を返す
	Team selectByTeamId(String id);
}
