package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Room;

@Mapper
// 場所に対する操作を提供するインターフェース
public interface RoomMapper {

	List<Room> selectAll();

	String selectNameById(String roomId);
	

}
