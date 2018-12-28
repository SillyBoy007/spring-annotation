package com.wang.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wang.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *   spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *   开发，测试，生产环境
 * @Profile 指定组件在哪个环境下才能被注册到容器中。
 * 1)加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中,默认是default
 *
 *
 * 切换环境:
 * 1 使用命令行动态参数:在虚拟机参数位置加载-Dspring.profiles.active=test
 * 2  使用无参构造器切换环境
 *      1).创建一个application无参构造（不能使用有参构造，要自己写）
 *      2).设置需要激活的环境
 *      3).注册主配置类
 *      4).启动刷新容器
 *
 * 3.写在配置类上,只有指定环境的时候,整个配置类里面的所有配置才能开始生效
 * 4.没有@Profile标识的bean在 ，任何环境下都是加载的。
 *
 */
@Profile("test")
@PropertySource("classpath:dbconfgig.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String username;

    private StringValueResolver valueResolver;//值解析器
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username); //属性中直接获取配置文件中的值

        comboPooledDataSource.setPassword(password); //参数中获取配置文件的值
        comboPooledDataSource.setUser("jdbc:mysql://localhost:3306/test");
        String driverClass = valueResolver.resolveStringValue("${db.driverClass}"); //使用值解析器获取配置文件中的值
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }
    @Profile("product")
    @Bean("proDataSource")
    public DataSource dataSourceProduct(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/product");
        String driverClass = valueResolver.resolveStringValue("${db.driverClass}");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }
    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDevelop(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/develop");
        String driverClass = valueResolver.resolveStringValue("${db.driverClass}");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver = stringValueResolver;
    }
}
