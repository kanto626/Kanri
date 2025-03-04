package com.example.app.service;

import java.util.List;

import com.example.app.domain.Room;

// 場所に対する操作を提供するインターフェース
public interface RoomService {

	// RoomMapper を利用し、場所ID、場所の名称のリストを返す
	List<Room> getAll();

	String getNameById(String roomId);
}
