package member_25.service;

import java.util.List;


import member_25.model.*;

public interface MemberService {

	boolean existsById(String id);

	void save(membershipInformationBean mb);

	List<MemberBean> findAll();

	MemberBean findById(int pk);

	void delete(int pk);

	void update(membershipInformationBean mb);
	
	//前置下拉選單 
	List<membershipInformationBean>  getIdentificationList();


}