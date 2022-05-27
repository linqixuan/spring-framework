package com.lqx.beandefinitions.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linqx
 * @version 1.0
 * @classname MyImportSelector
 * @description TODO
 * @date 2022/5/27 10:44
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		importingClassMetadata.getAnnotationTypes().forEach(System.out::println);
		if(importingClassMetadata.hasAnnotation("com.lqx.beandefinitions.beans.MyEnableAnnotation")){
			return new String[]{"com.lqx.beandefinitions.beans.ImportSelectorBean"};
		}
		return null;
	}
}


