package cn.acqz.springframework.context.event;


import cn.acqz.springframework.beans.factory.BeanFactory;
import cn.acqz.springframework.context.ApplicationEvent;
import cn.acqz.springframework.context.ApplicationListener;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {

    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {

    }
}
