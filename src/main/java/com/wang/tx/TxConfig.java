package com.wang.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务
 * 1.环境搭建:导入相关依赖:数据源，数据库驱动
 * 2.配置数据源，spring-jdbc模块(jdbctmplate,也可以导入mybatis以及hibernate,jpa)
 * 3.给方法标注:@Transactional 表示当前方法是一个事务方法
 * 4.配置类上加上@EnableTransactionManagement开启基于注解的事务管理
 * 5.配置事务管理器控制事务
 *
 * @EnableTransactionManagement原理:
 * 1).导入 TransactionManagementConfigurationSelector
 * 2).导入两个组件AutoProxyRegistrar和ProxyTransactionManagementConfiguration
 *
 *
 */
@ComponentScan({"com.wang.tx","com.wang.service","com.wang.dao"})
@Configuration
@EnableTransactionManagement
public class TxConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return comboPooledDataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        //spring对Configuration类有特殊处理，给容器中加组件的方法，多次调用都会从容器中找组件
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
