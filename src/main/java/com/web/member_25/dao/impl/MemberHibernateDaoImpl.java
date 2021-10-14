package com.web.member_25.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.member_25.dao.MemberDao;
import com.web.member_25.model.MemberBean;
import com.web.member_25.model.membershipInformationBean;

//import ch01.dao.MemberDao;
//import ch01.model.MemberBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
@Repository
public class MemberHibernateDaoImpl implements MemberDao {

	SessionFactory factory;

	@Autowired
	public MemberHibernateDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean existsById(String id) {
		Session session = factory.getCurrentSession();
		boolean result = false;

		String hql = "FROM MemberBean m WHERE m.id = :mid";
//		List<MemberBean> beans = session.createQuery(hql, MemberBean.class)
//				                        .setParameter("mid", id)
//				                        .getResultList();
//		if (beans.size() > 0) {
//			result = true;
//		} else {
//			result = false;
//		}
		try {
			session.createQuery(hql, MemberBean.class).setParameter("mid", id).getSingleResult();
			result = true;
		} catch (NoResultException e) {
			result = false;
		} catch (NonUniqueResultException e) {
			result = true;
		}

		return result;
	}

	@Override
	public void save(membershipInformationBean mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public List<MemberBean> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean";
		List<MemberBean> beans = session.createQuery(hql, MemberBean.class).getResultList();
		return beans;
	}

	@Override
	public membershipInformationBean findById(int id) {
		Session session = factory.getCurrentSession();
		membershipInformationBean mb = session.get(membershipInformationBean.class, id);
//		membershipInformationBean mb=session.get(membershipInformationBean.class, userEmail);
		return mb;
	}

	@Override
	public void delete(int pk) {
		Session session = factory.getCurrentSession();
		MemberBean mb = new MemberBean();
		mb.setPk(pk);
		session.delete(mb);
	}

	@Override
	public void update(membershipInformationBean mb) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
	}

	public int login(String userEmail, String userPwd) {
		Session session = factory.getCurrentSession();

		int loginState = 0;
		System.out.println("===================loginDAO執行中=");

		try {
//			 Query query=session.createQuery(hql);
//                   .getSingleResult();

			Query query = session.createQuery(
					"FROM membershipInformationBean where userEmail=:userEmail and userPwd=:userPwd",
					membershipInformationBean.class);
			query.setParameter("userEmail", userEmail);
			query.setParameter("userPwd", userPwd);
			System.out.println("===================HQL執行完畢query=" + query);
			System.out.println("===================HQL執行完畢=");

			System.out.println("query.getSingleResult()-------------> " + query.getSingleResult());
			loginState = 1;
		} catch (NoResultException e) {
			System.out.println("沒帳號拉");
			loginState = 2;
		} catch (NonUniqueResultException e) {
			System.out.println("多筆帳號拉");
			loginState = 3;
		}

		return loginState;

	}

	@Override
	public int overlappedAccount(String userEmail) {
		Session session = factory.getCurrentSession();
		int loginState = 0;
		System.out.println("===================overlappedAccount執行中=");

		try {
			Query query = session.createQuery(
					"FROM membershipInformationBean where userEmail=:userEmail",
					membershipInformationBean.class);
			query.setParameter("userEmail", userEmail);
			System.out.println("query.getSingleResult()-------------> " + query.getSingleResult());
			loginState = 1;
		} catch (NoResultException e) {
			System.out.println("沒人使用此帳號");
			loginState = 2;
		} catch (NonUniqueResultException e) {
			System.out.println("多筆帳號拉 怎麼可能!! 一定是菸捲搞的鬼");
			loginState = 3;
		}

		return loginState;
	}

//	//前置的下拉選單
//	@Override
//	public List<membershipInformationBean> getIdentificationList() {
//		Session session = factory.getCurrentSession();
//		System.out.println("前置的下拉選單功能在此 getIdentificationList");
//	    String hql = "FROM MembershipInformationBean";
//	    List<membershipInformationBean> list = session.createQuery(hql, membershipInformationBean.class)
//	    		                        .getResultList();
//	    return list;
//	}
}
