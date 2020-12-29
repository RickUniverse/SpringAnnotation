package com.springannotation.config;

import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author lijichen
 * @date 2020/11/27 - 16:19
 */
public class MyFilterType implements TypeFilter {

    /**
     * @param metadataReader ： 读取到当前正在扫描的类的信息
     * @param metadataReaderFactory ： 可以获取到其他任何类信息的
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源
        Resource resource = metadataReader.getResource();
        if (classMetadata.getClassName().contains("er")) {
            return true;
        }

        return false;
    }
}
