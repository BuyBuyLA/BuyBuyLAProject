package com.web.cart_30.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.cart_30.dao.CartDao;
import com.web.cart_30.model.Cart;
import com.web.cart_30.model.RecordBean;
import com.web.cart_30.model.RidCount;
import com.web.cart_30.service.CartService;




@Service
public class CartServiceImpl implements CartService {
	
	CartDao cartDao;
	SessionFactory factory;
	
	@Autowired
	public CartServiceImpl(CartDao cartDao, SessionFactory factory) {
	
		this.cartDao = cartDao;
		this.factory = factory;
	}





	@Transactional
	@Override
	public void addItemByid(int pid) {
		System.out.println("serviceqqqqqqqqqqqqqqqqqqqqqqqqq");
		cartDao.addItemByid(pid);
	}




	

	@Transactional
	@Override
	public boolean existsById(int pid) {
		System.out.println("ssssssssssssssssss");
		return cartDao.existsById(pid);
	}


	@Transactional
	@Override
	public void add(int pid) {
		cartDao.add(pid);
		
	}


	@Transactional
	@Override
	public void sub(int pid) {
		cartDao.sub(pid);
		
	}


	@Transactional
	@Override
	public void deletecart(int pid) {
		cartDao.deletecart(pid);
		
	}


	@Transactional
	@Override
	public List<Cart> addToRecord() {
		Session session = factory.getCurrentSession();
//		List<Cart> cart = new ArrayList<Cart>();
		String hql = "FROM Cart";
		List<Cart> cart = session.createQuery(hql,Cart.class)
		.getResultList();
		
		return cart;
	
	}
	
	
	
	@Transactional
	@Override
	public void addToRecord2(RecordBean rb) {
		cartDao.addToRecord(rb);
		
	}

	@Transactional
	@Override
	public void deleteAll() {
		cartDao.deleteAll();
		
	}




	@Transactional
	@Override
	public int getRidCount(int id) {
		Session session = factory.getCurrentSession();
		
		int rc = session.get(RidCount.class,id)
				.getRidcount();
		System.out.println(rc+"************************************");
		
		return rc;
		
	}




	@Transactional
	@Override
	public void addRidCount() {
		cartDao.addRidCount(1);
		
	}







}
