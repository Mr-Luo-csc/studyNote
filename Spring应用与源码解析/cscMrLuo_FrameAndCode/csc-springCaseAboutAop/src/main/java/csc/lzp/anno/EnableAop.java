package csc.lzp.anno;

import csc.lzp.myimport.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Discription: 自定义是否开启AOP支持的注解
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)
public @interface EnableAop {


}
