package com.ssafy.fit.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.ssafy.fit.model.dao")
//@EnableTransactionManagement
public class DBConfig {
//	private String driverClassName = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
//    private String username = "ssafy";
//    private String password = "ssafy";
// 
//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
// 
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return transactionManger();
//    }
// 
//    @Bean
//    public PlatformTransactionManager transactionManger() {
//        return new DataSourceTransactionManager(dataSource());
//    }
}
