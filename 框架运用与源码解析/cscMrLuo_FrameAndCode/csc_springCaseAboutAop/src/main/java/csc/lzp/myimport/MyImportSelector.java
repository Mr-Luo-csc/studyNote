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

        return new String[]{IndexDao2.class.getName()};
    }

}
