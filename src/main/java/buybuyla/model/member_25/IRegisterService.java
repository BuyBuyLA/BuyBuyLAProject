package buybuyla.model.member_25;

import java.util.List;

public interface IRegisterService {

	boolean existsByMemberId(String id) throws Exception;

	void save(Member mem) throws Exception;

	List<Member> findAll() throws Exception;

}