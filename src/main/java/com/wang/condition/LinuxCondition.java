package com.wang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //3.获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");

        if (property.contains("Linux")){
            return true;
        }
        else {
            return false;
        }
    }
}
