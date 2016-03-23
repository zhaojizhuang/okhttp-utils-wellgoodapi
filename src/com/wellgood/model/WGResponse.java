package com.wellgood.model;

import com.alibaba.fastjson.JSONObject;

public class WGResponse {

private   String data;
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
@Override
public String toString() {
	return "WGResponse [data=" + data + "]";
}

}
