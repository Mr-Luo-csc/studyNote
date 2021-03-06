package csc.lzp.annotationspring.util;

import csc.lzp.annotationspring.anno.MyServiceAnnotate;

import java.io.File;
import java.io.UnsupportedEncodingException;
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
        try {
            rootPath = java.net.URLDecoder.decode(rootPath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String basePackagePath = basePackage.replaceAll("\\.", "\\/");

        File file = new File(rootPath + "//" + basePackagePath);
        //得到文件名数组,存储
        String names[] = file.list();
        for (String name : names) {
            name = name.replaceAll(".class", "");
            try {
                Class clazz = Class.forName(basePackage + "." + name);

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

    /**
     * 获取某个文件夹下面的所有文件
     *
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("/Users/luozhipeng/Desktop/毕业设计源文件");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }

}
