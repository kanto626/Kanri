package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Placement;

@Mapper
public interface PlacementMapper {

	// 備品IDを元に、配置情報(場所名と数量)のリストを返す
	List<Placement> selectByItemId(int itemId);
}
