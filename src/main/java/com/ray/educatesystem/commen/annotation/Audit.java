package com.ray.educatesystem.commen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Package:com.ray.educatesystem.commen.annotation
 * *Author:ray
 * *version:...
 * *Created in 2019/7/21  23:49
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {

	String name();

	String action();
}
