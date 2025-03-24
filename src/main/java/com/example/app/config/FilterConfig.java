package com.example.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.app.filter.AuthFilter;

@Configuration
// AuthFilter を有効化するための設定ファイル
public class FilterConfig implements WebMvcConfigurer{

	// 認証用フィルタの有効化
	@Bean
	FilterRegistrationBean<AuthFilter> authFilter() {
	var bean =
	new FilterRegistrationBean<AuthFilter>(new AuthFilter());
	bean.addUrlPatterns("/admin/*", "/team/*");
	return bean;
	}
}
