package com.web.celebrations_36.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.celebrations_36.dao.CampaignDao;
import com.web.celebrations_36.model.Campaign;


@Repository
public class CampaignDaoImpl implements CampaignDao{
	
	SessionFactory factory;
	
	@Autowired
	public CampaignDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}


	@Override
	public void save(Campaign campaign) {
		Session session = factory.getCurrentSession();
		session.save(campaign);
	}

	@Override
	public List<Campaign> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Campaign";
		List<Campaign> beans = session.createQuery(hql, Campaign.class).getResultList();
		return beans;
	}

	@Override
	public Campaign findById(int campaignId) {
		Session session = factory.getCurrentSession();
		Campaign cam = session.get(Campaign.class, campaignId);
		return cam;
	}

	@Override
	public void delete(int campaignId) {
		Session session = factory.getCurrentSession();
		Campaign cam = new Campaign();
		cam.setId(campaignId);
		session.delete(cam);
	}

	@Override
	public void update(Campaign campaign) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(campaign);
	}



}
