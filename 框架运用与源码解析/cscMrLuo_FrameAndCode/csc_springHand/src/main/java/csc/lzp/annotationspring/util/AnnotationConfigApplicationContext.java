package csc.lzp.annotationspring.util;

import csc.lzp.annotationspring.anno.MyServiceAnnotate;

import java.io.File;
import java.lang.annotation.Annotation;

/**
 * @Discription: 注解版 初始化spring容器
 * @Author: luozhipeng
 * @Date: 2020/5/30
 **/
public class AnnotationConfigApplicationContext {

    public void scan(String basePackage) {
        //得到所有的类 classes 文件夹环境下的包名 方式: 通过文件名得到类名

        String rootPath = this.getClass().getResource("/").getPath();

        String basePackagePath = basePackage.replaceAll("\\.", "\\\\");

        File file = new File(rootPath + "//" + basePackagePath);
        //得到文件名数组,存储
        String names[] = file.list();
        for (String name : names) {
            name = name.replaceAll(".class", "");
            try {
                Class clazz = Class.forName(basePackagePath + name);

                //@autowire注解的解析使用
                //clazz.getDeclaredFields();
                //控制顺序 使用两个map来实现试一试

                //判断是否是属于 某个注解
                if (clazz.isAnnotationPresent(MyServiceAnnotate.class)) {
                    Annotation annotation = clazz.getAnnotation(MyServiceAnnotate.class);
                    System.out.println("注解: " + annotation);
                    System.out.println(clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
