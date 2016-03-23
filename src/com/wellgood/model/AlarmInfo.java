package com.wellgood.model;

import java.io.Serializable;

import android.util.Log;
/**
 * 
 * @author zhaojizhuang
 *	@date  2015-10-30
 *主机的状态，包括主机编号，和状态，撤布防，或是在线离线 0在线 1离线 2撤防 3 布放
 */
public class AlarmInfo implements Serializable {
	/**
	 * 
	 */
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	@Override
	public String toString() {
		return "AlarmInfo [HostNumber=" + HostNumber + ", OnLinestatus="
				+ OnLinestatus + ", RCstatus=" + RCstatus + "]";
	}



	public String getHostNumber() {
		return HostNumber;
	}
	public void setHostNumber(String hostNumber) {
		HostNumber = hostNumber;
	}



	/** 主机编号**/
    public  String HostNumber;    

	/**在线离线状态 **/
    public Boolean OnLinestatus;
    /**撤防布放状态 **/
    public Boolean RCstatus;
    public AlarmInfo(){
    	super();
    }
    public AlarmInfo(String HostNumber,Boolean OnLinestatus,Boolean RCstatus){
    	this.HostNumber=HostNumber;
    	this.OnLinestatus=OnLinestatus;
    	this.RCstatus=RCstatus;
    	Log.d("AlarmInfo","AlarmInfo:构造函数"+this.toString() );
    }
    public Boolean getOnLinestatus() {
		return OnLinestatus;
	}
	public void setOnLinestatus(Boolean onLinestatus) {
		this.OnLinestatus = onLinestatus;
	}
	public Boolean getRCstatus() {
		return RCstatus;
	}
	public void setRCstatus(Boolean rCstatus) {
		this.RCstatus = rCstatus;
	}

    
}