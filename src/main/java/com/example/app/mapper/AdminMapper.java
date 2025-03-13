package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Admin;

@Mapper
public interface AdminMapper {
	//ログインIDを元に、管理者情報を返す
	Admin selectByLoginId(String loginId);
}
