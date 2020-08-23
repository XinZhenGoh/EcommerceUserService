package com.usermanagement.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnableBcryptCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return "yes".equalsIgnoreCase(conditionContext.getEnvironment().getProperty("enable.Bcrypt"));
    }
}
