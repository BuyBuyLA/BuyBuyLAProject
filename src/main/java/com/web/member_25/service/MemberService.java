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
	
	boolean login(String userEmail, String userPwd);
	
	
	
//	//前置下拉選單 
//	List<membershipInformationBean>  getIdentificationList();


}