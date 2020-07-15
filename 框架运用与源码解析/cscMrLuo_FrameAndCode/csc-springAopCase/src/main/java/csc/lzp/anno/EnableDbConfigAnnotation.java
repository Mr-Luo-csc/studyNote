package csc.lzp.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Discription: 通过注解中给属性赋值
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableDbConfigAnnotation {

    String username() default "root";

    String password() default "admin123";

}
