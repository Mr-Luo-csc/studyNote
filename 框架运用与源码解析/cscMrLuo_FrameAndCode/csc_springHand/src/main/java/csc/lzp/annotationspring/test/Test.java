package csc.lzp.annotationspring.test;

import csc.lzp.annotationspring.util.AnnotationConfigApplicationContext;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/5/31
 **/
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("csc.lzp.annotationspring.service");

    }
}
