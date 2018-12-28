package com.wang.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//默认加在ioc容器组件，容器启动会调用无参构造创建对象，再进行初始化赋值等
@Component
public class Boss {
    private Cat cat;

    //@Autowired //标注有参构造器上，要用的组件也在容器中获取。
    public Boss(@Autowired Cat cat) {  //也可以放在参数上
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }
   // @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "cat=" + cat +
                '}';
    }
}
