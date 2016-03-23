package com.wellgood.model;

import java.io.Serializable;

import android.util.Log;
/**
 * 
 * @author zhaojizhuang
 *	@date  2015-10-30
 *主机的报警信息状态
 */
public class AlarmNews implements Serializable {

	


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	/** 主机编号**/
	public String HostNum;
	/*报警信息*/
    public  String Msg;
    /*报警信息发生的时间*/
    public String Time;

    public AlarmNews(){
    	super();
    }

	public String getHostNum() {
		return HostNum;
	}

	public void setHostNum(String hostNum) {
		HostNum = hostNum;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	@Override
	public String toString() {
		return "AlarmNews [HostNum=" + HostNum + ", Msg=" + Msg + ", Time="
				+ Time + "]";
	}

    
}