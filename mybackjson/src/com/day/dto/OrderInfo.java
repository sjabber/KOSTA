package com.day.dto;

import java.util.Date;
import java.util.List;

public class OrderInfo {
	
	private int order_no;
//	private String order_id;
	private Customer order_c; // N의 입장에서 1을 갖는 hasA관계로 설정
	private Date order_dt ; // 
	private List<OrderLine> lines; // OrderInfo 1의 입장에서 List N을 갖는 hasA관계로 설정
	
	public OrderInfo() {
	}
	
	
	public OrderInfo(Customer order_c) {
		super();
		this.order_c = order_c;
	}


	public OrderInfo(Customer order_c, List<OrderLine> lines) {
		super();
		this.order_c = order_c;
		this.lines = lines;
	}

	public OrderInfo(int order_no, Customer order_c, Date order_dt, List<OrderLine> lines) {
		super();
		this.order_no = order_no;
		this.order_c = order_c;
		this.order_dt = order_dt;
		this.lines = lines;
	}


	public int getOrder_no() {
		return order_no;
	}


	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}


	public Customer getOrder_c() {
		return order_c;
	}


	public void setOrder_c(Customer order_c) {
		this.order_c = order_c;
	}


	public Date getOrder_dt() {
		return order_dt;
	}


	public void setOrder_dt(Date order_dt) {
		this.order_dt = order_dt;
	}


	public List<OrderLine> getLines() {
		return lines;
	}


	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}


	@Override
	public String toString() {
		return "OrderInfo [order_no=" + order_no + ", order_c=" + order_c + ", order_dt=" + order_dt + ", lines="
				+ lines + "]";
	}
}
