package buybuyla.model.member_25;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet("/ch04/ex03/createMember.do")
public class CreateTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String sqlDropBLOBTable = "Drop TABLE MemberExample";
        // MySQL 
		
		 String sqlCreateBLOBTable =
		 "CREATE TABLE MemberExample (PK int PRIMARY KEY auto_increment, "
		 +
		 " account varchar(32), password varchar(32), name varchar(32), email varchar(64), "
		 + " tel  varchar(15), experience int) "
		 +
		 " ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci";
		 

		Statement stmt = null;
		Connection conn = null;

		List<String> errorMsgs = new ArrayList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		List<String> messages = new ArrayList<String>();
		req.setAttribute("messages", messages);
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlDropBLOBTable);
			messages.add("刪除表格 MemberExample 成功");
		} catch (NamingException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			messages.add("刪除表格 MemberExample 失敗, " + e.getMessage());
		}
		try {
			stmt.executeUpdate(sqlCreateBLOBTable);
			messages.add("建立表格 MemberExample 成功");
			RequestDispatcher rd = req
					.getRequestDispatcher("/ch04/ex03/createTable/createTableSuccess.jsp");
			rd.forward(req, res);
		} catch (SQLException e) {
			messages.add("刪除表格 MemberExample 失敗");
			errorMsgs.add(e.getMessage());
			RequestDispatcher rd = req
					.getRequestDispatcher("/ch04/ex03/createTable/createTableError.jsp");
			rd.forward(req, res);
			return;
		} finally {
			// 這裡一定要 conn.close();
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}