package com.distribution.entity;

public class TableReport {
	private String org_id;
	private String org_nm;
	private String pro_id;
	private String pro_nm;
	private String pdate;
	private String cate_id;
	private String cate_nm;
	private String brd_id;
	private String brd_nm;
	private String sal_qty;
	private String sal_amt;
	private String pro_prm;
	private String inv_qty;
	@Override
	public String toString() {
		return "tableReport [org_id=" + org_id + ", org_nm=" + org_nm
				+ ", pro_id=" + pro_id + ", pro_nm=" + pro_nm + ", pdate="
				+ pdate + ", cate_id=" + cate_id + ", cate_nm=" + cate_nm
				+ ", brd_id=" + brd_id + ", brd_nm=" + brd_nm + ", sal_qty="
				+ sal_qty + ", sal_amt=" + sal_amt + ", pro_prm=" + pro_prm
				+ ", inv_qty=" + inv_qty + "]";
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getOrg_nm() {
		return org_nm;
	}
	public void setOrg_nm(String org_nm) {
		this.org_nm = org_nm;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_nm() {
		return pro_nm;
	}
	public void setPro_nm(String pro_nm) {
		this.pro_nm = pro_nm;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_nm() {
		return cate_nm;
	}
	public void setCate_nm(String cate_nm) {
		this.cate_nm = cate_nm;
	}
	public String getBrd_id() {
		return brd_id;
	}
	public void setBrd_id(String brd_id) {
		this.brd_id = brd_id;
	}
	public String getBrd_nm() {
		return brd_nm;
	}
	public void setBrd_nm(String brd_nm) {
		this.brd_nm = brd_nm;
	}
	public String getSal_qty() {
		return sal_qty;
	}
	public void setSal_qty(String sal_qty) {
		this.sal_qty = sal_qty;
	}
	public String getSal_amt() {
		return sal_amt;
	}
	public void setSal_amt(String sal_amt) {
		this.sal_amt = sal_amt;
	}
	public String getPro_prm() {
		return pro_prm;
	}
	public void setPro_prm(String pro_prm) {
		this.pro_prm = pro_prm;
	}
	public String getInv_qty() {
		return inv_qty;
	}
	public void setInv_qty(String inv_qty) {
		this.inv_qty = inv_qty;
	}
	
	
	
}
