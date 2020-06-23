package csc.lzp.myimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/6/23
 **/
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }

}
