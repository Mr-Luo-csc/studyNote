package csc.lzp.myimport;

import csc.lzp.dao.IndexDao2;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //判断是否加了@enableAop注解
        //annotationMetadata.getMetaAnnotationTypes("");

        //把annotation里面的字段与value，解读出来成map，字段名是key，value为value
        //AnnotationAttributes attributes = AnnotationConfigUtils.attributesFor(amd, type);
        //判断annotation是否有效，是否存在作为beanName的字段有value
        //isStereotypeWithNameValue(v1,v2,v3)方法

//        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();//得到所有annotation的类名
//        for (String annotationType : annotationTypes) {
//            annotationMetadata.getMetaAnnotationTypes(annotationType);
//        }

        return new String[]{IndexDao2.class.getName()};
    }

}
