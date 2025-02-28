package com.example.app.domain;

import java.sql.Date;

import lombok.Data;

@Data
// 資材情報を保持するためのクラス
public class Item {

	private Integer id;
	private String name;
	private Date purchasedAt;
	private String note;
	
	// テーブル連携時
	private Integer amount;
}
