package csc.lzp.config;

import csc.lzp.anno.EnableDbConfigAnnotation;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Discription: 数据库配置
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Component
public class DbConfig implements ImportAware {

    //属性
    private String username;
    private String password;

    //通过注解操作属性赋值
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        //Set<MethodMetadata> data = annotationMetadata.getAnnotatedMethods("EnableDbConfigAnnotation");
        Map<String, Object> map = annotationMetadata.getAnnotationAttributes(EnableDbConfigAnnotation.class.getName());
        AnnotationAttributes attrs = AnnotationAttributes.fromMap(map);
        //赋值属性
        this.username = attrs.getString("username");
        this.password = attrs.getString("password");
    }

    //getter方法
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
