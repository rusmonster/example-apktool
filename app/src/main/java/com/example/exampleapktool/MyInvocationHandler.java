package com.example.exampleapktool;

import com.example.exampleapktool.annotations.FindMe;
import com.google.common.reflect.AbstractInvocationHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyInvocationHandler extends AbstractInvocationHandler {

	/**
	 * @return Value of the first parameter annotated with {@link FindMe},
	 * {@code null} if parameter not found.
	 */
	@Override
	protected Object handleInvocation(final Object proxy, final Method method,
									  final Object[] args) throws Throwable {
		/**
		 * After repacking apk with apktool_2.0.0rc1 next line crashes on Android 4.0.4 for
		 * method {@link MyExample#crash}, but works for method {@link MyExample#workaround}.
		 * On Android 4.4.4 it works good for both methods.
		 */
		final Annotation[][] parameterAnnotationArrays = method.getParameterAnnotations();

		for (int i = 0; i < args.length; i++) {
			final Annotation[] parameterAnnotations = parameterAnnotationArrays[i];
			for (final Annotation annotation : parameterAnnotations) {
				if (annotation.annotationType() == FindMe.class) {
					return args[i];
				}
			}
		}

		return null;
	}
}
