package com.wellgood.model;

import java.util.ArrayList;
import java.util.List;

public class MyCameraInfo {

    /** cameraId */
    public String cameraID = null;
    /** 名称�?*/
    public String name = null;
    /**摄像头缩略图 */
    public String imageUrl=null;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCameraID() {
		return cameraID;
	}
	public void setCameraID(String cameraID) {
		this.cameraID = cameraID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
  
}
