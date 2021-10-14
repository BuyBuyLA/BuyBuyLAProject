package com.web.member_25.service;

import java.util.List;

import com.web.member_25.model.MemberBean;
import com.web.member_25.model.membershipInformationBean;



public interface MemberService {

	boolean existsById(String id);

	void save(membershipInformationBean mb);

	List<MemberBean> findAll();

	membershipInformationBean findById(int id);

	void delete(int pk);

	void update(membershipInformationBean mb);
	
	int login(String userEmail, String userPwd);
	
	int overlappedAccount(String userEmail);
	
	
//	//前置下拉選單 
//	List<membershipInformationBean>  getIdentificationList();


}