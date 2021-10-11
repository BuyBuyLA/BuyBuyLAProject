package com.web.member_25.dao;

import java.util.List;

import com.web.member_25.model.*;

public interface MemberDao {

	boolean existsById(String id);

	void save(MemberBean mb);

	List<MemberBean> findAll();

	MemberBean findById(int pk);

	void delete(int pk);

	void update(MemberBean mb);

}