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

public class RegisterDao implements IRegisterDao {
	Context ctx;
	String jndiLookup = "java:comp/env/jdbc/MemberDataBaseM";

	public RegisterDao() throws Exception {
		ctx = new InitialContext();
	}

	@Override
	public boolean existsByMemberId(String id) throws Exception {
		boolean exist = false;
		String sql = "SELECT * FROM memberExample WHERE account = ?";
		DataSource ds = (DataSource) ctx.lookup(jndiLookup);
		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		}
		return exist;
	}

	@Override
	synchronized public void save(Member mem) throws Exception {
		DataSource ds = (DataSource) ctx.lookup(jndiLookup);
		String sql = "Insert into memberExample " 
				+ " (account, password, name, email, tel, experience) "
				+ " values(?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection conn = ds.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			stmt.setString(1, mem.getUserId());
			stmt.setString(2, mem.getPassword());
			stmt.setString(3, mem.getName());
			stmt.setString(4, mem.getEmail());
			stmt.setString(5, mem.getTel());
			stmt.setInt(6, mem.getExperience());
			stmt.executeUpdate();
		}
		
	}

	@Override
	public List<Member> findAll() throws Exception {

		DataSource ds = (DataSource) ctx.lookup(jndiLookup);
		List<Member> allMembers = new ArrayList<Member>();
		try (
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * from  memberExample");
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				Member mem = new Member(rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getInt(7));
				allMembers.add(mem);
			}
		}
		return allMembers;
	}
}
