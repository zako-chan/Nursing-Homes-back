package com.example.ex3_2_back.log;


import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//统计接口的耗时以及输入输出等日志信息
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Mapping
public @interface TakeCount {

}