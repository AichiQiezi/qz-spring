package cn.acqz.springframework.aop;

/**
 * Core Spring pointcut abstraction.
 * A pointcut is composed of a ClassFilter and a MethodMatcher.
 * @author feng
 * @date 2023/7/26 16:01
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
