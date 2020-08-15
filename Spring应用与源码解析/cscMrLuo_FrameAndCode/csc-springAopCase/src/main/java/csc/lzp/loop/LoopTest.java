package csc.lzp.loop;

import csc.lzp.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Discription: spring用三个map来实现bean的循环依赖, 实际上使用的是两个, 有一个map是用来判断注入的属性值是否一致
 * @Author: luozhipeng
 * @Date: 2020/7/20
 **/
public class LoopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        LoopA loopA = context.getBean(LoopA.class);
        System.out.println("============循环依赖LoopA:============" + loopA);
    }

}
