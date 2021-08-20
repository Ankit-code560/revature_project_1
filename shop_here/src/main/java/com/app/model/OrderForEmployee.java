package com.app.model;

public class OrderForEmployee {

	private int oid;
	private String name;
	private int uid;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "OrderForEmployee [oid=" + oid + ", name=" + name + ", uid=" + uid + "]";
	}
	
}
