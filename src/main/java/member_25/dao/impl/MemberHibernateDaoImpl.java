package member_25.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import ch01.dao.MemberDao;
//import ch01.model.MemberBean;

import member_25.dao.MemberDao;
import member_25.model.MemberBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
@Repository
public class MemberHibernateDaoImpl implements MemberDao  {
	
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
		    session.createQuery(hql, MemberBean.class)
			       .setParameter("mid", id)
                   .getSingleResult();
		    result = true;
		} catch(NoResultException e) {
			result = false;
       	} catch(  NonUniqueResultException e) {
			result = true;
		}
		
		return result;
	}

	@Override
	public void save(MemberBean mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public List<MemberBean> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean";
		List<MemberBean> beans = session.createQuery(hql, MemberBean.class)
				                        .getResultList();
		return beans;
	}

	@Override
	public MemberBean findById(int pk) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, pk);
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
	public void update(MemberBean mb) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
	}
}
