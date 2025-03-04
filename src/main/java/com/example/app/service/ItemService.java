package com.example.app.service;

import java.util.List;

import com.example.app.domain.Item;

public interface ItemService {

	List<Item> getAll();

	Item getOneById(int id); // 資材IDを元に1件分の資材情報を返す
	
	// 資材IDを元に、ID、品名、総数、購入日、備考のリストを返す
	List<Item> getByRoomId(String roomId);
}
