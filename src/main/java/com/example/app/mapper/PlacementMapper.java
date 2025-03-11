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

	// placements テーブルに配置情報を追加する
	void insert(Placement placement);
	
	// placements テーブルに配置情報を追加する。
	// 備品ID と場所ID の組が重複する場合は、追加ではなく更新する
	void insertOrUpdate(List<Placement> placementList);
	
	// 数量が0個の場合、配置情報を削除する。ただし「倉庫」の配置情報については削除しない
	void deleteZero();
	
	// 既存のselectByItemId(int itemId)を拡張したようなメソッド
	// すべての場所情報との連携を行う点が異なる
	List<Placement> selectAllRoomsByItemId(int itemId);
}
