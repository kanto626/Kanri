package com.example.app.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.app.filter.AuthFilter;

@Configuration
// AuthFilter を特定のURLパターンに適用しつつ、有効化するための設定ファイル
public class FilterConfig implements WebMvcConfigurer {

	// 認証用フィルタの有効化
	@Bean 
	FilterRegistrationBean<AuthFilter> authFilter() {
		var bean = new FilterRegistrationBean<AuthFilter>(new AuthFilter());
		bean.addUrlPatterns("/admin/*", "/team/*");
		return bean;
	}
}

/* お決まりの構文
  @Bean 
FilterRegistrationBean<フィルタークラス> メソッド名() {
    var bean = new FilterRegistrationBean<>(new フィルタークラス());
    bean.addUrlPatterns("対象URLパターン"); // この行をなくすと全適用
    return bean;
}
*/