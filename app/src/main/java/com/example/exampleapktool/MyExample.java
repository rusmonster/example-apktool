package com.example.exampleapktool;

import com.example.exampleapktool.annotations.FakeAnnotation;
import com.example.exampleapktool.annotations.FindMe;

public interface MyExample {
	String crash(@FindMe String param1, String param2);

	String workaround(@FindMe String param1, @FakeAnnotation String param2);
}
