package com.wang.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会返回到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean ... ");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //是否单例

    /**
     * true 单例
     * false 多例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
