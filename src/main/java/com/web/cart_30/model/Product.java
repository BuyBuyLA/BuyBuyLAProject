package com.web.cart_30.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	private String p_name;
	private String pc_id;
	private Integer p_price;
	private Integer p_cnt;
	private String p_info;
	private String p_img;
	private String seller;
	
	public Product() {
		
	}

	public Product(Integer pid) {
	
		this.pid = pid;
	}




	public Product(Integer pid, String p_name, String pc_id, Integer p_price, Integer p_cnt, String p_info,
			String p_img, String seller) {
		
		this.pid = pid;
		this.p_name = p_name;
		this.pc_id = pc_id;
		this.p_price = p_price;
		this.p_cnt = p_cnt;
		this.p_info = p_info;
		this.p_img = p_img;
		this.seller = seller;
	}

	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getPc_id() {
		return pc_id;
	}


	public void setPc_id(String pc_id) {
		this.pc_id = pc_id;
	}


	public Integer getP_price() {
		return p_price;
	}


	public void setP_price(Integer p_price) {
		this.p_price = p_price;
	}


	public Integer getP_cnt() {
		return p_cnt;
	}


	public void setP_cnt(Integer p_cnt) {
		this.p_cnt = p_cnt;
	}


	public String getP_info() {
		return p_info;
	}


	public void setP_info(String p_info) {
		this.p_info = p_info;
	}


	public String getP_img() {
		return p_img;
	}


	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}



}
