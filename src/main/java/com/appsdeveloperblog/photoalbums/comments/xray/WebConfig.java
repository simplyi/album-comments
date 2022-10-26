package com.appsdeveloperblog.photoalbums.comments.xray;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.xray.javax.servlet.AWSXRayServletFilter;

@Configuration
public class WebConfig {

	@Bean
	public Filter TracingFilter() {
		return new AWSXRayServletFilter("album-comments-service-with-discovery");
	}

}