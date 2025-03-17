package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
// 管理者情報を保持するためのクラス
public class Admin {
	@NotBlank
	private String loginId;
	@NotBlank
	private String loginPass;
	private String name;

}
