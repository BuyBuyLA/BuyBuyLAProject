package com.web.product_11.dao;

import java.util.List;


import com.web.product_11.model.Product;



public interface ProductDao {
	//查詢全部商品
	List<Product>  getAllProducts(); 
		
	//查詢商品類別
	List<String>  getAllCategories();
	
	//獲取類別商品
	List<Product>  getProductsByCategory(String category);
	
	//ID查詢商品
	Product getProductById(int productId);
	
	//新增商品
	void  addProduct(Product product);
	
	//更新商品
	void updateProduct(int productId,Product product);
	
}
