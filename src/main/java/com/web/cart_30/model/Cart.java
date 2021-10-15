package com.web.cart_30.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Cart")
public class Cart {
	@Id
	private Integer pid;	
	private String p_img;
	private String p_name;
	private Integer p_price;
	private Integer count;
	private String buyer;
	private String seller;
	

	public Cart() {
	
	}


	public Cart(Integer pid) {

		this.pid = pid;
	}




	public Cart(Integer pid, String p_img, String p_name, Integer p_price, Integer count, String buyer, String seller) {

		this.pid = pid;
		this.p_img = p_img;
		this.p_name = p_name;
		this.p_price = p_price;
		this.count = count;
		this.buyer = buyer;
		this.seller = seller;
	}


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getP_img() {
		return p_img;
	}


	public void setP_img(String p_img) {
		this.p_img = p_img;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public Integer getP_price() {
		return p_price;
	}


	public void setP_price(Integer p_price) {
		this.p_price = p_price;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public String getBuyer() {
		return buyer;
	}


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
	
	
}
