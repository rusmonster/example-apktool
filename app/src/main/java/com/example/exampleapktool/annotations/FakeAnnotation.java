package com.example.exampleapktool.annotations;

import com.example.exampleapktool.MyInvocationHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * We never analyze this annotation in our code, just use it for workaround
 * bug in apktool_2.0.0rc1. See {@link MyInvocationHandler#handleInvocation}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface FakeAnnotation {
}