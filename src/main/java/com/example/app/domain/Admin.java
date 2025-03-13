package com.example.app.domain;

import lombok.Data;

@Data
// 管理者情報を保持するためのクラス
public class Admin {

	private String loginId;
	private String loginPass;
	private String name;

}
