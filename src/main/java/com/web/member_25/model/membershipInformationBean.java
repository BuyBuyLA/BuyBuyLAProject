package com.web.member_25.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membershipInformation")
public class membershipInformationBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(name="userEmail")
	String userEmail;
	@Column(name="userPhone")
	String userPhone;
	@Column(name="userPwd")
	String userPwd;
	@Column(name="userName")
	String userName;
	@Column(name="userGender")
	String userGender;
	@Column(name="address")
	String address;
	@Column(name="head_shot")
	String head_shot;
	@Column(name="Identification")
	String Identification;
	
	
	public membershipInformationBean(Integer id, String userEmail, String userPhone, String userPwd, String userName,
			String userGender, String address, String head_shot, String identification) {
		this.id = id;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userGender = userGender;
		this.address = address;
		this.head_shot = head_shot;
		this.Identification = identification;
	}
	
	
	public membershipInformationBean() {
		
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHead_shot() {
		return head_shot;
	}
	public void setHead_shot(String head_shot) {
		this.head_shot = head_shot;
	}
	public String getIdentification() {
		return Identification;
	}
	public void setIdentification(String identification) {
		Identification = identification;
	}
	
	

}
