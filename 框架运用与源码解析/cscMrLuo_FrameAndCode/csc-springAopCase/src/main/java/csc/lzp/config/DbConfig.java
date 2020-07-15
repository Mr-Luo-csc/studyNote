package csc.lzp.config;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @Discription: 数据库配置
 * @Author: luozhipeng
 * @Date: 2020/7/15
 **/
@Component
public class DbConfig implements ImportAware {

    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        Set<MethodMetadata> data = annotationMetadata.getAnnotatedMethods("EnableDbConfigAnnotation");
    }

}
