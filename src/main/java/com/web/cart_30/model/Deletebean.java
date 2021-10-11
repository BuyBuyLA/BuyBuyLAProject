package com.web.cart_30.model;


import java.io.Serializable;

public class Deletebean implements Serializable{
	private  int record_id;

	public Deletebean() {

	}

	public Deletebean(int record_id) {
		this.record_id=record_id;
	}

	public  int getRecord_id() {
		return record_id;
	}

	public  void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
}