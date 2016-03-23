package com.wellgood.model;

public class MyRegionInfo {
	public String regionName;
	public String regionID;
	public String getRegionName() {
		return regionName;
	}
	public MyRegionInfo(String regionName, String regionID) {
		super();
		this.regionName = regionName;
		this.regionID = regionID;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getRegionID() {
		return regionID;
	}
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}
	@Override
	public String toString() {
		return "MyRegionInfo [regionName=" + regionName + ", regionID="
				+ regionID + "]";
	}
}
