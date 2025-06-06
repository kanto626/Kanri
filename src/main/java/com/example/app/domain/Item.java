package com.example.app.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
// 資材情報を保持するためのクラス
public class Item {

	private Integer id;

	@NotBlank
	@Size(max = 30)
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate purchasedAt;

	@Size(max = 255)
	private String note;

	// テーブル連携時
	@NotNull
	@Min(value = 0)
	@Max(value = 9999)
	private Integer amount;
	
	@Valid
	private List<Placement> placementList; // 配置情報を保持

	// カテゴリを追加
	@NotBlank
	@Size(max = 30)
	private String category;
}
