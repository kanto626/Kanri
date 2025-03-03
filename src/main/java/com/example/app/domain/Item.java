package com.example.app.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
// 資材情報を保持するためのクラス
public class Item {

	private Integer id;
	private String name;
	private LocalDate purchasedAt;
	private String note;

	// テーブル連携時
	private Integer amount;
	private List<Placement> placementList; // 配置情報を保持
}
