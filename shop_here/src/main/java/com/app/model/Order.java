package com.app.model;

public class Order {

	private int uid;
	private int pid;
	private int status;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Order [uid=" + uid + ", pid=" + pid + ", status=" + status + "]";
	}
	
	
}
