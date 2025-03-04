package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Item;

@Mapper
public interface ItemMapper {
	List<Item> selectAll();

	Item selectById(int id); // 資材IDを元に1件分の資材情報を返す
	
	// 場所IDを元に、ID、品名、総数、購入日、備考のリストを返す
	List<Item> selectByRoomId(String roomId);
}
