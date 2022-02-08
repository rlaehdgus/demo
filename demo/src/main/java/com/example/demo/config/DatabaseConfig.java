package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfig {

   /* @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }*/

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource ) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource( dataSource );
        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources( "classpath:/config/mybatis/mapper/*Mapper.xml" ) );
        sqlSessionFactoryBean.setConfigLocation( new PathMatchingResourcePatternResolver().getResource( "classpath:/config/mybatis/mybatis-config.xml" ) );

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate( SqlSessionFactory sqlSessionFactory ) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate( sqlSessionFactory );

        return sqlSessionTemplate;
    }
}
