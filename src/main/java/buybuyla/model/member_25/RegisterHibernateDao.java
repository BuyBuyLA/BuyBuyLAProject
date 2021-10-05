package buybuyla.model.member_25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RegisterHibernateDao implements IRegisterDao {
//因為有session 標籤  所以只需要去sessionfactory
	
	SessionFactory factory;

	@Autowired
	public RegisterHibernateDao(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public boolean existsByMemberId(String id) throws Exception {
		boolean exist = false;
		
		//改寫
		String hql="FROM Member m WHERE m.userId = :sid"; //m是自訂的物件名 然後輸入.userId
		Session session=factory.getCurrentSession();
		List<Member> members=session.createQuery(hql,Member.class)
									.setParameter("sid", id)
									.getResultList();  
		//多 用法(用1筆的singleResult的話 多筆or0筆就會出事)
		
		if(members.size()>0) {
			exist=true;
		}
		return exist;
	}

	@Override
	synchronized public void save(Member mem) throws Exception {
		//改寫
		Session session=factory.getCurrentSession();
		session.save(mem);
	}

	@Override
	public List<Member> findAll() throws Exception {
		//改寫
				Session session=factory.getCurrentSession(); //session由工廠產生
		String hql="FROM Member";
		return session.createQuery(hql,Member.class)
				.getResultList();

	}
}
