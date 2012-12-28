/*
 *  Copyright (c) 2012 Chute Corporation

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.chute.android.albumtutorial.intent;

import com.chute.android.albumtutorial.activity.AssetActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class AssetActivityIntentWrapper extends IntentWrapper {

	@SuppressWarnings("unused")
	private static final String TAG = AssetActivityIntentWrapper.class
			.getSimpleName();

	private static final String KEY_ALBUM_ID = "albumId";
	private static final String KEY_ASSET_ID = "assetId";

	public AssetActivityIntentWrapper(Context context) {
		super(context, AssetActivity.class);
	}

	public AssetActivityIntentWrapper(Intent intent) {
		super(intent);
	}

	public String getAlbumId() {
		return getIntent().getExtras().getString(KEY_ALBUM_ID);
	}

	public void setAlbumId(String albumId) {
		getIntent().putExtra(KEY_ALBUM_ID, albumId);
	}

	public String getAssetId() {
		return getIntent().getExtras().getString(KEY_ASSET_ID);
	}

	public void setAssetId(String assetId) {
		getIntent().putExtra(KEY_ASSET_ID, assetId);
	}

	public void startActivity(Activity context) {
		context.startActivity(getIntent());
	}
}