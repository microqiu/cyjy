package com.linfeiyang.shop.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.linfeiyang.shop.mybatis.mapper"})
@ComponentScan({"com.linfeiyang.shop.service"})
@ConfigurationProperties(prefix = "datasource")
public class DataConfig {


    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl("jdbc:mysql://127.0.0.1:3306/cyjy?characterEncoding=UTF-8");
        datasource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        datasource.setUsername("root");
        datasource.setPassword("123456");
        //物理连接数
        datasource.setInitialSize(3);
        //最小连接数
        datasource.setMinIdle(1);
        //60秒超时
        datasource.setMaxWait(60000);
        datasource.setRemoveAbandoned(true);
        datasource.setFilters("config,stat,wall");
        datasource.setConnectionProperties("config.decrypt=false");
        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String MAPPER_XML_PATH = "classpath*:com/linfeiyang/shop/mybatis/mapper/xml/*Mapper.xml";
        sessionFactory.setMapperLocations(resolver.getResources(MAPPER_XML_PATH));
        org.apache.ibatis.session.Configuration configuration = sessionFactory.getObject().getConfiguration();
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        configuration.setCallSettersOnNulls(true);
        configuration.setLogImpl(StdOutImpl.class);
        return sqlSessionFactoryBuilder.build(configuration);
    }


}
