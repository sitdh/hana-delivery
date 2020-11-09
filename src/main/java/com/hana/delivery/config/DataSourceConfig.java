package com.hana.delivery.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
//	public DataSource getDataSource() {
//		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder<DataSource>.create();
//		dataSourceBuilder.driverClassName("org.h2.Driver");
//		dataSourceBuilder.url("jdbc:h2:mem:test");
//		dataSourceBuilder.username("SA");
//		dataSourceBuilder.password("");
//		
//		return dataSourceBuilder.build();
//	}
}
