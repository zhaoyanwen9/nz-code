package com.nz.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class MybatisCaches {

    private SqlSessionFactory factory;

    @Bean
    public void loadMybatisConfig() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Bean
    public void showDefaultCacheConfiguration() {
        System.out.println("一级缓存范围: " + factory.getConfiguration().getLocalCacheScope());
        System.out.println("二级缓存是否被启用: " + factory.getConfiguration().isCacheEnabled());
    }
}
