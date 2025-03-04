package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Item;
import com.example.app.domain.Placement;
import com.example.app.mapper.ItemMapper;
import com.example.app.mapper.PlacementMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemMapper itemMapper;
	private final PlacementMapper placementMapper;

	@Override
	public List<Item> getAll() {
		return itemMapper.selectAll();
	}

	@Override
	public Item getOneById(int id) {
		Item item = itemMapper.selectById(id);

		// 配置情報
		List<Placement> list = placementMapper.selectByItemId(id);

		// 資材の総数
		int amount = 0;
		for (Placement p : list) {
			amount += p.getAmount();
		}

		// itemに配置情報、資材総数をまとめる
		item.setPlacementList(placementMapper.selectByItemId(id));
		item.setAmount(amount);
		return item;
	}

	@Override
	public List<Item> getByRoomId(String roomId) {
		return itemMapper.selectByRoomId(roomId);
	}
}
