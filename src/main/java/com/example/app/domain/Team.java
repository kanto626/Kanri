package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// チーム情報を保持するためのクラス
public class Team {
	@NotBlank
	private String id;
	private String roomId;

	@NotBlank
	private String loginPass;
	private String name;
}
