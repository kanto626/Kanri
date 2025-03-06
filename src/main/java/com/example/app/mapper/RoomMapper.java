package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Room;

@Mapper
// 場所に対する操作を提供するインターフェース
public interface RoomMapper {

	// 場所ID、場所の名称のリストを返す
	List<Room> selectAll();

	// 場所IDを元に1件分の場所の名称を返す
	String selectNameById(String roomId);

}
