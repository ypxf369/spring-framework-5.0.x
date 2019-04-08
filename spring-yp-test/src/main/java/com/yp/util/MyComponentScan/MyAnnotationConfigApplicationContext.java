package com.yp.util.MyComponentScan;

import java.io.File;

/**
 * Created by yepeng on 2019/03/20.
 */
public class MyAnnotationConfigApplicationContext {
	private String dir = ".";

	public void scan(String basePackage) {
		String basePath = this.getClass().getResource("/").getPath() + basePackage.replaceAll("\\.", "/");
		File file = new File(basePath);
		scanPath(file, basePackage);
	}

	private void scanPath(File file, String basePackage) {
		File[] files = file.listFiles();
		try {
			for (File f : files) {
				String fileName = f.getName();
				if (!f.isDirectory()) {
					if (fileName.endsWith(".class")) {
						Class<?> clazz = Class.forName(basePackage + dir + fileName.replace(".class", ""));
						if (clazz.isAnnotationPresent(MyComponent.class)) {
							MyComponent annotation = clazz.getAnnotation(MyComponent.class);
							String value = annotation.value();
							System.out.println(value);
						}
					}
				} else {
					dir += fileName + ".";
					scanPath(f, basePackage);
				}
			}
			dir = ".";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
