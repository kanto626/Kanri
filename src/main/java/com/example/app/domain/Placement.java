package com.example.app.domain;

import lombok.Data;

@Data
// 資材の配置情報を保持するためのドメインクラス
public class Placement {

	private Item item;
	private Room room;
	private Integer amount;
}
