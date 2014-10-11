package com.example.exampleapktool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.common.reflect.Reflection;

public class MyActivity extends Activity {
	private final MyExample mMyExample =
			Reflection.newProxy(MyExample.class, new MyInvocationHandler());

	private TextView mTextView;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		mTextView = (TextView) findViewById(R.id.text);
	}

	public void onCrashClick(final View view) {
		final String text = mMyExample.crash("findMe in #crash", "otherParam");
		mTextView.setText(text);
	}

	public void onWorkaroundClick(final View view) {
		final String text = mMyExample.workaround("findMe in #workaround", "otherParam");
		mTextView.setText(text);
	}
}
