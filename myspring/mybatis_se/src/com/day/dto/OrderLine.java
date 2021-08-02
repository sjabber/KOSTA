package com.day.dto;

public class OrderLine {
	
	
	private int order_no;
	// private OrderInfo order_i; 이런 설계는... (X) 실제 화면 측에서 이런 과정은 많지 않으므로.
	// private String order_prod_no; 아래로 변경 (SoSo)
	private Product order_p; // Product를 hasA 관계로 설계함(OrderLine 자식(N) 입장에서 Product 부모(1)를 hasA 관계로 설정)
	private int order_quantity;

	public OrderLine() {
	}
	
	
	
	public OrderLine(Product order_p, int order_quantity) {
		super();
		this.order_p = order_p;
		this.order_quantity = order_quantity;
	}



	public int getOrder_no() {
		return order_no;
	}



	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}



	public Product getOrder_p() {
		return order_p;
	}



	public void setOrder_p(Product order_p) {
		this.order_p = order_p;
	}



	public int getOrder_quantity() {
		return order_quantity;
	}



	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}



	@Override
	public String toString() {
		return "OrderLine [order_no=" + order_no + ", order_p=" + order_p + ", order_quantity=" + order_quantity + "]";
	}



	
}
