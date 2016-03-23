package com.wellgood.API.callback;

import okhttp3.Call;
import okhttp3.Response;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wellgood.API.WellGood;
import com.wellgood.model.LoginResponse;
import com.zhy.http.okhttp.callback.Callback;

/**
 * 
 * @author Administrator
 *
 */
public abstract class LoginCallback extends Callback<String>
{
	
	@Override
	public String parseNetworkResponse(Response response)
			throws Exception {
		// TODO Auto-generated method stub
	      String string = response.body().string();
	        Log.i(WellGood.TAG, ""+response);
	      //  LoginResponse loginResponse = JSON.parseObject(string, LoginResponse.class);
	        return string;
	}

	@Override
	public void onError(Call call, Exception e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onResponse(String response) {
		// TODO Auto-generated method stub
		Log.i(WellGood.TAG, ""+response);
		
		String  content =WellGood.getContentFromResponse(response);
		Log.i(WellGood.TAG, "content"+content);
		LoginResponse loginResponse = JSON.parseObject(content,
				LoginResponse.class);
		
		Log.i(WellGood.TAG, "loginResponse"+loginResponse);
		
		
		onResponse(loginResponse);
	}
/**
 * 必须实现的方法，返回的参数为LoginResponse对象
 * @param response
 */
	public abstract void onResponse(LoginResponse loginresponse);

}
