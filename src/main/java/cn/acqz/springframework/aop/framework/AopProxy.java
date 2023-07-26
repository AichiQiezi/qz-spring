package cn.acqz.springframework.aop.framework;

/**
 * Delegate interface for a configured AOP proxy,
 * allowing for the creation of actual proxy objects.
 * Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by DefaultAopProxyFactory AOP
 * @author feng
 * @date 2023/7/26 19:34
 */

public interface AopProxy {
    Object getProxy();
}
