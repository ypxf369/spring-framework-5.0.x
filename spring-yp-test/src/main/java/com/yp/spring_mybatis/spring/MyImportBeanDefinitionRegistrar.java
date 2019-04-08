package com.yp.spring_mybatis.spring;

import com.yp.spring_mybatis.annotation.MyMapperScan;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.util.Set;

/**
 * Created by yepeng on 2019/04/08.
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if (!importingClassMetadata.hasAnnotation("com.yp.spring_mybatis.annotation.MyMapperScan")) {
			throw new RuntimeException("not found mapper's package");
		}
		String packageName = importingClassMetadata.getAnnotationAttributes("com.yp.spring_mybatis.annotation.MyMapperScan").get("packageName").toString();
		// 扫描包
		String basePath = this.getClass().getResource("/").getPath() + packageName.replaceAll("\\.", "/");
		File file = new File(basePath);
		File[] files = file.listFiles();
		for (File file1 : files) {
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyMapperFactoryBean.class);
			AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
			String fileName = file1.getName().replace(".class", "");
			//beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(TestDao.class);
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(packageName + "." + fileName);
			registry.registerBeanDefinition(Character.isUpperCase(fileName.codePointAt(0)) ? (char)(fileName.charAt(0) + 32) + fileName.substring(1) : fileName, beanDefinition);
		}

	}
}
