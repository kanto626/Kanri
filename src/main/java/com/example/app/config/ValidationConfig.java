package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ValidationConfig implements WebMvcConfigurer {

	// validation.properties を有効化
	@Override
	public Validator getValidator() {
		var validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Bean // 戻り値 messageSource()をSpringの管理対象として登録
	ResourceBundleMessageSource messageSource() {
		var messageSource = new ResourceBundleMessageSource();
		 // resources/validation.properties を参照
		messageSource.setBasename("validation");
		return messageSource;
	}

}
/*
 getValidator() は 親インターフェースで定義されているため
 　オーバーライドしてカスタマイズする
 */