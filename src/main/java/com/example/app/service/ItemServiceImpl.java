package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Item;
import com.example.app.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemMapper itemMapper;

	@Override
	public List<Item> getAll() {
		return itemMapper.selectAll();
	}
}
