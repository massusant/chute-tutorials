package com.chute.android.createalbumtutorial.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chute.android.createalbumtutorial.R;
import com.chute.android.createalbumtutorial.intent.AlbumActivityIntentWrapper;
import com.chute.sdk.v2.api.album.GCAlbums;
import com.chute.sdk.v2.api.asset.GCAssets;
import com.chute.sdk.v2.api.comment.GCComments;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.requests.ListResponseModel;
import com.chute.sdk.v2.model.requests.ResponseModel;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public class AlbumActivity extends Activity {

	public static final String TAG = AlbumActivity.class.getSimpleName();
	private AlbumActivityIntentWrapper wrapper;
	private TextView albumName;
	private AlbumModel album = new AlbumModel();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.album_activity);

		wrapper = new AlbumActivityIntentWrapper(getIntent());

		albumName = (TextView) findViewById(R.id.txtName);
//		album.setName(wrapper.getAlbumName());
		album.setId(wrapper.getAlbumId());
		AssetModel asset = new AssetModel();
		asset.setId("5857");
		GCComments.get(getApplicationContext(), album, asset, new CommentsCallback()).executeAsync();
//		GCAssets.Votes.delete(getApplicationContext(), album, asset, new VotesCallback()).executeAsync();
//		GCComments.create(getApplicationContext(), album, asset, new CommentsCallback()).executeAsync();
//		GCAlbums.create(getApplicationContext(), album,
//				new CreateAlbumCallback()).executeAsync();

	}
	
	private final class VotesCallback implements HttpCallback<ResponseModel<AssetModel>> {

		@Override
		public void onSuccess(ResponseModel<AssetModel> responseData) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private final class CommentsCallback implements HttpCallback<ListResponseModel<CommentModel>> {


		@Override
		public void onHttpError(ResponseStatus responseCode) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ListResponseModel<CommentModel> responseData) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private final class CreateAlbumCallback implements
			HttpCallback<ResponseModel<AlbumModel>> {

		@Override
		public void onSuccess(ResponseModel<AlbumModel> responseData) {
			albumName.setText(responseData.getData().getName());
			Toast.makeText(
					getApplicationContext(),
					getApplicationContext().getResources().getString(
							R.string.album_created), Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onHttpError(ResponseStatus responseCode) {
			Toast.makeText(
					getApplicationContext(),
					getApplicationContext().getResources().getString(
							R.string.http_error), Toast.LENGTH_SHORT).show();

		}

	}

}