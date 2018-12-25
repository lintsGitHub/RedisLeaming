package priv.lint.redisForSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        redisService bean = context.getBean(redisService.class);
//        bean.addHello();
        bean.sayHi();
    }
}
