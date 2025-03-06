package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Placement;

@Mapper
public interface PlacementMapper {

	// 備品IDを元に、配置情報(場所名と数量)のリストを返す
	List<Placement> selectByItemId(int itemId);

	// 配置情報(placements テーブルのレコード)の件数を返す
	Long countDistinctByItemId();

	// 場所ID によって絞り込まれた、配置情報の件数を返す
	Long countByRoomId(String roomId);

	// 資材ID を元に、placements テーブルからデータの削除を行う
	void deleteByItemId(int itemId);
}
