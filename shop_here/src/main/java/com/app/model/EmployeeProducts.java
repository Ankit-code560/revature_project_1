package com.app.model;

public class EmployeeProducts {

	private int pId;
	private String proName;
	private String proCategory;
	private double proPrice;
	private int proOrderedCount;
	
	public EmployeeProducts() {}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public int getProOrderedCount() {
		return proOrderedCount;
	}
	public void setProOrderedCount(int proOrderedCount) {
		this.proOrderedCount = proOrderedCount;
	}

	@Override
	public String toString() {
		return "EmployeeProducts [pId=" + pId + ", proName=" + proName + ", proCategory=" + proCategory + ", proPrice="
				+ proPrice + ", proOrderedCount=" + proOrderedCount + "]";
	}
	
	
}
