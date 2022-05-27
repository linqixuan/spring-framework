package com.lqx.beandefinitions.beans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author linqx
 * @version 1.0
 * @annotationname MyEnableAnnotation
 * @description TODO
 * @date 2022/5/27 10:45
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEnableAnnotation {
}
