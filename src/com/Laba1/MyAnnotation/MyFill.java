package com.Laba1.MyAnnotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(ElementType.METHOD)
@Retention(value = RUNTIME)
public @interface MyFill {

    String title();

}
