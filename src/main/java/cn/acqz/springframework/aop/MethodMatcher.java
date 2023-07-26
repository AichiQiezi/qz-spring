package cn.acqz.springframework.aop;

import java.lang.reflect.Method;

/**
 * Part of a {@link Pointcut}: Checks whether the target method is eligible for advice.
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
    
}
