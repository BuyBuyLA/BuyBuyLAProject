package com.web.cart_30.dao;

import com.web.cart_30.model.RecordBean;

public interface CartDao {
	public void addItemByid(int pid);
	public boolean existsById(int pid);
	public void add(int pid);
	public void sub(int pid);
	public void deletecart(int pid);
	public void addToRecord(RecordBean rb);
	public void addRidCount(int id);
	public void deleteAll();
}