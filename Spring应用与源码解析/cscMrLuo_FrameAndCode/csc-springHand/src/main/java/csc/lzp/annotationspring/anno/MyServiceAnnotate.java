package csc.lzp.annotationspring.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/31
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyServiceAnnotate {

    public String value();

}
