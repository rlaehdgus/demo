package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@MapperScan( basePackages = {"com/example/demo/member"} )
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    /*@Bean
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource ) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource( dataSource );
        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources( "classpath:mapper/*Mapper.xml" ) );
        sqlSessionFactoryBean.setConfigLocation( new PathMatchingResourcePatternResolver().getResource( "classpath:config/mybatis-config.xml" ) );

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate( SqlSessionFactory sqlSessionFactory ) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate( sqlSessionFactory );

        return sqlSessionTemplate;
    }*/
}
