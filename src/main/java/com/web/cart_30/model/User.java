package com.web.cart_30.model;



import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int record_id;
	private static int  pID;
	private static String  p_name;	 
	private static int  p_price;
	private static int  pcount;
	
	public User() {
		
	}
	public User(int record_id,int pID,String  p_name,int  p_price, int  pcount) {
		
	}
	
	public static int getRecord_id() {
		return record_id;
	}
	public static void setRecord_id(int record_id) {
		User.record_id = record_id;
	}
	public static int getpID() {
		return pID;
	}
	public static void setpID(int pID) {
		User.pID = pID;
	}
	public static String getP_name() {
		return p_name;
	}
	public static void setP_name(String p_name) {
		User.p_name = p_name;
	}
	public static int getP_price() {
		return p_price;
	}
	public static void setP_price(int p_price) {
		User.p_price = p_price;
	}
	public static int getPcount() {
		return pcount;
	}
	public static void setPcount(int pcount) {
		User.pcount = pcount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	 
 


	
	


}
