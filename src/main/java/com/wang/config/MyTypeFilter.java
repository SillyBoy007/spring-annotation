package com.wang.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
//自定义类型过滤器
public class MyTypeFilter implements TypeFilter {
    //metadataReader读取到当前扫描到的类的信息
    //metadataReaderFactory可以获取其他任何类的信息
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata(); //获取当前扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();//获取当前扫描类的类信息
        Resource resource = metadataReader.getResource();//获取当前扫描类的资源信息

        String className = classMetadata.getClassName();
        System.out.println("className--->"+className);


        if (className.contains("Dao")){
            return true;
        }else {
            return false;
        }

    }
}
