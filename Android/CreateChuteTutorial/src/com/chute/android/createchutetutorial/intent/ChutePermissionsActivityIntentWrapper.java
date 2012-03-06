package com.chute.android.createchutetutorial.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.chute.android.createchutetutorial.app.ChutePermissionsActivity;

public class ChutePermissionsActivityIntentWrapper {

	public static final String TAG = ChutePermissionsActivityIntentWrapper.class
			.getSimpleName();
	private static final String KEY_CHUTE_NAME = "chuteName";
	private static final String KEY_CHUTE_PASSWORD = "chutePassword";

	private final Intent intent;

	public ChutePermissionsActivityIntentWrapper(Intent intent) {
		super();
		this.intent = intent;
	}

	public ChutePermissionsActivityIntentWrapper(Context packageContext,
			Class<?> cls) {
		super();
		intent = new Intent(packageContext, cls);
	}

	public ChutePermissionsActivityIntentWrapper(Context packageContext) {
		super();
		intent = new Intent(packageContext, ChutePermissionsActivity.class);
	}

	public Intent getIntent() {
		return intent;
	}

	public void setChuteName(String name) {
		intent.putExtra(KEY_CHUTE_NAME, name);
	}

	public String getChuteName() {
		return intent.getExtras().getString(KEY_CHUTE_NAME);
	}

	public void setChutePassword(String password) {
		intent.putExtra(KEY_CHUTE_PASSWORD, password);
	}

	public String getChutePassword() {
		return intent.getExtras().getString(KEY_CHUTE_PASSWORD);
	}

	public void startActivity(Activity context) {
		context.startActivity(intent);
	}
}