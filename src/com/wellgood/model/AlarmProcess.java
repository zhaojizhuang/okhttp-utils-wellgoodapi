package com.wellgood.model;

import java.io.Serializable;

import android.util.Log;
/**
 * 
 * @author zhaojizhuang
 *	@date  2015-10-30
 *主机的撤布防进程状态
 */
public class AlarmProcess implements Serializable {

	


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	/** 主机编号**/
	public String HostNum;
	/*报警信息进度显示*/
    public  String RealTimeStatus;    

    public AlarmProcess(){
    	super();
    }

	@Override
	public String toString() {
		return "AlarmProcess [HostNum=" + HostNum + ", RealTimeStatus="
				+ RealTimeStatus + "]";
	}

	public String getHostNum() {
		return HostNum;
	}

	public void setHostNum(String hostNum) {
		HostNum = hostNum;
	}

	public String getRealTimeStatus() {
		return RealTimeStatus;
	}

	public void setRealTimeStatus(String realTimeStatus) {
		RealTimeStatus = realTimeStatus;
	}
    
}