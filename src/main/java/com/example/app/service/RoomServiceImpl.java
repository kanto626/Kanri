package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Room;
import com.example.app.mapper.RoomMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
// RoomService の実装クラス
public class RoomServiceImpl implements RoomService{
	
	private final RoomMapper roomMapper;
	
	@Override
	public List<Room> getAll() {
		return  roomMapper.selectAll();
	}

	@Override
	public String getNameById(String roomId) {
		return roomMapper.selectNameById(roomId);	}

}
