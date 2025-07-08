package com.shopnest.product;

public class Product {
	int pid;
	String pname;
	int pprice;
	String pimg;
	public Product(int pid, String pname, int pprice, String pimg) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pimg = pimg;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	
}
