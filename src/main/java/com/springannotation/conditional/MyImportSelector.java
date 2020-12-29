package com.springannotation.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lijichen
 * @date 2020/11/27 - 17:38
 */
public class MyImportSelector implements ImportSelector {
    /**
     * @param annotationMetadata : 当前@Import注解注解的类的所有注解信息
     * @return
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.springannotation.entities.Yellow",
                "com.springannotation.entities.Blue"};
    }
}
