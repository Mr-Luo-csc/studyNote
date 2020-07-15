package csc.lzp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Discription: 定义切点[声明规则、这里有很多表达式] == 定义切面[看你这里要怎么通知:前、后、环绕]
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Component
@Aspect
@EnableAspectJAutoProxy
public class OrderAspect {

    /****************************************/
    /** @EnableAspectJAutoProxy注解          */
    /** 开启注解版AOP功能 基于注解的方式实现AOP  */
    /****************************************/

    @Pointcut("execution(* csc.lzp.service.OrderServiceImpl.*(..))")
    public void myPoint() {
        //表达式: 这里切service包中所有的方法
    }

    @Before("myPoint()")
    public void doSomeTing() {
        //切面: 这里需要指定切点
        System.out.println("使用aop实现: [before前置通知]");
    }

}
