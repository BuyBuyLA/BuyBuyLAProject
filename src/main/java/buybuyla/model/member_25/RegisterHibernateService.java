package buybuyla.model.member_25;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RegisterHibernateService implements IRegisterService {

	IRegisterDao dao;

	
	@Autowired
	public RegisterHibernateService(IRegisterDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean existsByMemberId(String id) throws Exception {
		return dao.existsByMemberId(id);
	}

	@Override
	public void save(Member mem) throws Exception {
		dao.save(mem);
	}

	@Override
	public List<Member> findAll() throws Exception {
		return dao.findAll();
	}
}
