package com.springannotation.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lijichen
 * @date 2020/11/27 - 17:09
 */
public class WindowConditional implements Condition {

    /**
     *
     * @param conditionContext : 判断条件能使用的上下文
     * @param annotatedTypeMetadata ： 注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();

        if (environment.getProperty("os.name").contains("Window")) {
            return true;
        }
        return false;
    }
}
