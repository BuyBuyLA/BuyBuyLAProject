package com.web.product_11.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.product_11.dao.ProductDao;
import com.web.product_11.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	SessionFactory factory;
	
	
	@Autowired
	public ProductDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	public ProductDaoImpl() {
	}

	//查詢全部商品
	@Override
	public List<Product> getAllProducts() {
		Session session=factory.getCurrentSession();
		String hql="from Product";
		return session.createQuery(hql, Product.class).getResultList();
	}

	//查詢商品類別
	@Override
	public List<String> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	//獲取類別商品
	@Override
	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	//ID查詢商品
	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	//新增商品
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}
	
	//更新商品
	@Override
	public void updateProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		
	}
	
}
