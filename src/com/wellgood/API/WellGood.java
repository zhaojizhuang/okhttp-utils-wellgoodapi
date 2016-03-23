package com.wellgood.API;


import okhttp3.Call;
import okhttp3.Response;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ok.User;
import com.example.ok.UserCallback;
import com.wellgood.API.callback.LoginCallback;
import com.wellgood.config.Contract;
import com.wellgood.model.LoginResponse;
import com.wellgood.model.WGResponse;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

/**
 * wellgood所有接口api
 * @author Administrator
 *
 */
public class WellGood{
	public static String TAG="wellgood-api";

	/**
	 * 根据返回值解析出里面的 data
	 * @param response
	 * @return
	 */
	public static String getContentFromResponse(String response){
		WGResponse wgResponse=JSON.parseObject(response,WGResponse.class);
		String content=wgResponse.getData();
		
		return content;
	}
	/**
	 * 登录
	 * @param username
	 * @param password
	 */
	public static void login(String serverAddress,String username,String password,LoginCallback callback){
		//String url = "http://111.1.8.117:8080/user/login?user={%22usr_name%22:%22super%22,%22usr_pwd%22:%22123456%22}";
		
		JSONObject user=new JSONObject();
		user.put("usr_name", username);
		user.put("usr_pwd", password);
		String urlString=serverAddress+"/user/login?user="+user;
		Log.d(TAG, "login-url:"+urlString);
		OkHttpUtils
                 .get()//
                 .url(urlString)//
                 .build()//
                 .execute(callback);
	}
}
