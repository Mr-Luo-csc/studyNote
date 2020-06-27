package csc.lzp.anno;

import csc.lzp.handler.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/27
 **/
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface CSCScan {
}
