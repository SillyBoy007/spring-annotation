package com.wang.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
//Spring的容器不扫描Controller,交给SpringMvc扫描
@ComponentScan(value = "com.wang",excludeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
public class RootConig {
}
