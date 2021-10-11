package com.web.member_25.service;

import java.util.List;

import com.web.member_25.model.*;

public interface MemberService {

	boolean existsById(String id);

	void save(MemberBean mb);

	List<MemberBean> findAll();

	MemberBean findById(int pk);

	void delete(int pk);

	void update(MemberBean mb);


}