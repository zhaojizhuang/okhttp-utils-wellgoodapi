package com.example.ok;

import android.app.Activity;
import android.app.AliasActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wellgood.API.WellGood;
import com.wellgood.API.callback.LoginCallback;
import com.wellgood.config.Contract;
import com.wellgood.model.LoginResponse;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;

public class MainActivity extends Activity {

	private String mBaseUrl = "http://10.138.114.147:8080/okHttpServer/";

	private static final String TAG = "MainActivity";

	private TextView mTv;
	private ImageView mImageView;
	private ProgressBar mProgressBar;

	public class MyStringCallback extends StringCallback {
		@Override
		public void onBefore(Request request) {
			super.onBefore(request);
			setTitle("loading...");
		}

		@Override
		public void onAfter() {
			super.onAfter();
			setTitle("Sample-okHttp");
		}

		@Override
		public void onError(Call call, Exception e) {
			mTv.setText("onError:" + e.getMessage());
		}

		@Override
		public void onResponse(String response) {
			mTv.setText("onResponse:" + response);
		}

		@Override
		public void inProgress(float progress) {
			Log.e(TAG, "inProgress:" + progress);
			mProgressBar.setProgress((int) (100 * progress));
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTv = (TextView) findViewById(R.id.id_textview);
		mImageView = (ImageView) findViewById(R.id.id_imageview);
		mProgressBar = (ProgressBar) findViewById(R.id.id_progress);
		mProgressBar.setMax(100);
	}

	public void getHtml(View view) {
		String url = "http://111.1.8.117:8080/user/login?user={%22usr_name%22:%22super%22,%22usr_pwd%22:%22123456%22}";
		OkHttpUtils.get().url(url).build().execute(new MyStringCallback());

	}

	public void postString(View view) {
		
		WellGood.login(Contract.CONNECT_HOST, "super", "123456", new LoginCallback() {
			
			@Override
			public void onResponse(LoginResponse loginresponse) {
				// TODO Auto-generated method stub
			}
		});
//		String url = "http://111.1.8.117:8080/host/page?host={%22page%22:{%22pageNo%22:%221%22,%22pageSize%22:%222%22}}";
//		OkHttpUtils.get().url(url).build().execute(new MyStringCallback());
//		// String url = mBaseUrl + "user!postString";
//		// OkHttpUtils
//		// .postString()
//		// .url(url)
//		// .content(new Gson().toJson(new User("zhy", "123")))
//		// .build()
//		// .execute(new MyStringCallback());

	}

	public void postFile(View view) {
		File file = new File(Environment.getExternalStorageDirectory(),
				"messenger_01.png");
		if (!file.exists()) {
			Toast.makeText(MainActivity.this, "文件不存在，请修改文件路径",
					Toast.LENGTH_SHORT).show();
			return;
		}
		String url = mBaseUrl + "user!postFile";
		OkHttpUtils.postFile().url(url).file(file).build()
				.execute(new MyStringCallback());

	}

	public void getUser(View view) {
		//String url = "http://111.1.8.117:8080/user/login?user={%22usr_name%22:%22super%22,%22usr_pwd%22:%22123456%22}";
		WellGood.login(Contract.CONNECT_HOST, "super", "123456", new LoginCallback() {

			@Override
			public void onResponse(LoginResponse response) {
				// TODO Auto-generated method stub
				mTv.setText("onResponse:" + response);
			}

			@Override
			public void onError(Call call, Exception e) {
				// TODO Auto-generated method stub
				mTv.setText("Exception:" + e);
			}
		});

		// // String url = mBaseUrl + "user!getUser";
		// OkHttpUtils
		// .get()//
		// .url(url)//
		// // .addParams("username", "hyman")//
		// // .addParams("password", "123")//
		// .build()//
		// .execute(new UserCallback()
		// {
		// @Override
		// public void onError(Call call, Exception e)
		// {
		// mTv.setText("onError:" + e.getMessage());
		// }
		//
		// @Override
		// public void onResponse(User response)
		// {
		// mTv.setText("onResponse:" + response.username);
		// }
		// });
	}

	public void getUsers(View view) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "zhy");
		String url = mBaseUrl + "user!getUsers";
		OkHttpUtils//
				.post()//
				.url(url)//
				// .params(params)//
				.build()//
				.execute(new ListUserCallback()//
						{
							@Override
							public void onError(Call call, Exception e) {
								mTv.setText("onError:" + e.getMessage());
							}

							@Override
							public void onResponse(List<User> response) {
								mTv.setText("onResponse:" + response);
							}
						});
	}

	public void getHttpsHtml(View view) {
		String url = "https://kyfw.12306.cn/otn/";

		OkHttpUtils.get()//
				.url(url)//
				.build()//
				.execute(new MyStringCallback());

	}

	public void getImage(View view) {
		mTv.setText("");
		String url = "http://111.1.8.117:8080/host/page?host={%22page%22:{%22pageNo%22:%221%22,%22pageSize%22:%222%22}}";
		OkHttpUtils.get()
				//
				.url(url)
				//
				.tag(this)
				//
				.build()
				//
				.connTimeOut(20000).readTimeOut(20000).writeTimeOut(20000)
				.execute(new BitmapCallback() {
					@Override
					public void onError(Call call, Exception e) {
						mTv.setText("onError:" + e.getMessage());
					}

					@Override
					public void onResponse(Bitmap bitmap) {
						mImageView.setImageBitmap(bitmap);
					}
				});
	}

	public void uploadFile(View view) {

		File file = new File(Environment.getExternalStorageDirectory(),
				"messenger_01.png");
		if (!file.exists()) {
			Toast.makeText(MainActivity.this, "文件不存在，请修改文件路径",
					Toast.LENGTH_SHORT).show();
			return;
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "张鸿洋");
		params.put("password", "123");

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("APP-Key", "APP-Secret222");
		headers.put("APP-Secret", "APP-Secret111");

		String url = mBaseUrl + "user!uploadFile";

		OkHttpUtils.post()//
				.addFile("mFile", "messenger_01.png", file)//
				.url(url)//
				.params(params)//
				.headers(headers)//
				.build()//
				.execute(new MyStringCallback());
	}

	public void multiFileUpload(View view) {
		File file = new File(Environment.getExternalStorageDirectory(),
				"messenger_01.png");
		File file2 = new File(Environment.getExternalStorageDirectory(),
				"test1.txt");
		if (!file.exists()) {
			Toast.makeText(MainActivity.this, "文件不存在，请修改文件路径",
					Toast.LENGTH_SHORT).show();
			return;
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "张鸿洋");
		params.put("password", "123");

		String url = mBaseUrl + "user!uploadFile";
		OkHttpUtils.post()//
				.addFile("mFile", "messenger_01.png", file)//
				.addFile("mFile", "test1.txt", file2)//
				.url(url).params(params)//
				.build()//
				.execute(new MyStringCallback());
	}

	public void downloadFile(View view) {
		String url = "https://github.com/hongyangAndroid/okhttp-utils/blob/master/gson-2.2.1.jar?raw=true";
		OkHttpUtils//
				.get()//
				.url(url)//
				.build()
				//
				.execute(
						new FileCallBack(Environment
								.getExternalStorageDirectory()
								.getAbsolutePath(), "gson-2.2.1.jar")//
						{

							@Override
							public void onBefore(Request request) {
								super.onBefore(request);
							}

							@Override
							public void inProgress(float progress) {
								mProgressBar
										.setProgress((int) (100 * progress));
							}

							@Override
							public void onError(Call call, Exception e) {
								Log.e(TAG, "onError :" + e.getMessage());
							}

							@Override
							public void onResponse(File file) {
								Log.e(TAG,
										"onResponse :" + file.getAbsolutePath());
							}
						});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// OkHttpUtils.cancelTag(this);
	}
}
