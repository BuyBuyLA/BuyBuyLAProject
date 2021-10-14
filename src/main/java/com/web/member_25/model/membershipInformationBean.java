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
	@Column(name="USEREMAIL")
	String userEmail;
	@Column(name="USERPHONE")
	String userPhone;
	@Column(name="USERPWD")
	String userPwd;
	@Column(name="USERNAME")
	String userName;
	@Column(name="USERGENDER")
	String userGender;
	@Column(name="ADDRESS")
	String address;
	@Column(name="HEAD_SHOT")
	String head_shot;
	@Column(name="IDENTIFICATION")
	String Identification;
	
	
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
