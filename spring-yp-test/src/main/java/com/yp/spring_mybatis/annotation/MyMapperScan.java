package com.yp.spring_mybatis.annotation;

import com.yp.spring_mybatis.spring.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yepeng on 2019/04/09.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {
	String packageName() default "";
}
