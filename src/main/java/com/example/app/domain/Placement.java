package com.example.app.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
// 資材の配置情報を保持するためのドメインクラス
public class Placement {

	private Item item;
	private Room room;
	@NotNull
	@Min(value = 0)
	@Max(value = 9999)
	private Integer amount;
}
