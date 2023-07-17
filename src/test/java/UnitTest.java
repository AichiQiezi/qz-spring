import cn.acqz.springframework.beans.factory.BeanFactory;
import cn.acqz.springframework.beans.factory.config.BeanDefinition;
import cn.acqz.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author feng
 * @date 2023/7/16 20:47
 */

public class UnitTest {
    @Test
    public void test01(){
        System.out.println("cnm");
    }

    @Test
    public void testBeanFactory(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService1 = (UserService) defaultListableBeanFactory.getBean("userService");
        userService1.queryUserInfo();

        System.out.println(userService1 == userService);
    }
}
