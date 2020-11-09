package com.hana.delivery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="app")
@Data
public class AppConfig {
	private String lang;
	private String theme;
}
