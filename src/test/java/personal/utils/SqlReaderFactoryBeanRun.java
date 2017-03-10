package personal.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SqlReaderFactoryBeanRun {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "test.xml" });

        ((AbstractApplicationContext) context).registerShutdownHook();

        String str = context.getBean("sqlReader", String.class);

        System.out.println(str);

        ((AbstractApplicationContext) context).close();

    }
}
