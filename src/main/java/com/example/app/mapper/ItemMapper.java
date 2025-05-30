package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Item;

@Mapper
public interface ItemMapper {
	List<Item> selectAll(); // 全ての資材情報を返す

	Item selectById(int id); // 資材IDを元に1件分の資材情報を返す

	// 場所IDを元に、ID、品名、総数、購入日、備考のリストを返す
	List<Item> selectByRoomId(String roomId);

	// ( 既存の「selectAll」にLIMIT 句が追加された付加されたもの )
	List<Item> selectLimited(@Param("offset") int offset, @Param("num") int num);

	// 既存の「selectByRoomId」にLIMIT 句が追加された付加されたもの
	List<Item> selectLimitedByRoomId(@Param("roomId") String roomId, @Param("offset") int offset,
			@Param("num") int num);
	
	// 資材ID を元に、items テーブルからデータの削除を行う
	void deleteById(int id);

	// items テーブルに資材情報を追加する
	void insert(Item item);
	
	// items テーブル内の備品情報を更新する
	void update(Item item);

	// カテゴリと場所IDを元に、ID、品名、総数、購入日、備考のリストを返す
	List<Item> selectByCategoryAndRoom(String category, String roomId);

	// 指定されたカテゴリと場所に該当する資材の総数を取得
	Integer countByCategoryAndRoom(String category, String roomId);

	// 指定されたカテゴリに該当する資材のリストを、ページネーションを考慮して取得
	List<Item> selectByCategory(String category, int offset, int numPerPage);

	// 指定されたカテゴリに該当する資材の総数を取得
	Integer countByCategory(String category);
}
