package buybuyla.model.member_25;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class RegisterService implements IRegisterService {

	IRegisterDao dao;

	public RegisterService() throws IOException {

		try {
			dao = new RegisterDao();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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
