package buybuyla.model.record_30;

import java.awt.Desktop;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

import manage.HikariUtil;

public class UserDao {
	private Connection conn;
//	private HikariUtil connPool = new HikariUtil();

	// 連線
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		   String urlStr = "jdbc:sqlserver://localhost:1433;databaseName=shopping;user=sa;password=zxcv265358";

		   this.conn = DriverManager.getConnection(urlStr);

		   boolean status = !conn.isClosed();

		   if (status) {
		    System.out.println("==========================");
		    System.out.println("SQL連線開始!!");
		   }
//		conn = ds.getConnection();
//
//		boolean status = !conn.isClosed();
//
//		if (status) {
//			System.out.println("Open Connection!!");
//		}

	}

	// 關連線
	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("Close Connection!");
		}
	}

	// 搜尋資料
	public ArrayList<Select2bean> findDataByDistrict(String district) throws SQLException {
		ArrayList<Select2bean> s2BeanList = new ArrayList<Select2bean>();
		
		String sqlStr = "select * from record where buyer=?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setString(1, district);
		System.out.println("district="+district);
		ResultSet rs = preState.executeQuery();
		int count = 0;
		int i=0;
		
		int record_id;
		int pid;
		String p_name;
		int p_price;
		String buy_time ;
		String userEmail;
		int pcount ;
		
		while (rs.next()) {
			System.out.println("test start");
			record_id = rs.getInt(1);
			pid = rs.getInt(2);
			p_name = rs.getString(3);
			p_price = rs.getInt(4);
			buy_time = rs.getString(5);
			userEmail = rs.getString(6);
			pcount = rs.getInt(7);
			
			Select2bean	s2Bean = new Select2bean(record_id, pid, p_name, p_price, buy_time, userEmail, pcount);
			s2BeanList.add(s2Bean);
			
//			s[i]=(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getInt(4)+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));
			
			
//			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getInt(4)
//					+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7) );
			
//			System.out.println(s[i]);
			i+=1;
			count += 1;
		}		
		
		System.out.println("總共 : " + count + " 筆資料");
		rs.close();
		preState.close();
//		for(int j=0;j<s.length;j++) {
//			System.out.println("fin bean="+s[j]);
//		}
//		
		return s2BeanList;
		
	}




	// 刪除資料
	public void deleteById(int id) throws SQLException {
		String sqlStr = "delete from record where record_id = ?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1, id);
		int count = preState.executeUpdate();
		System.out.println("已刪除該筆資料");
		System.out.println("Delete data count: " + count);
		preState.close();
	}



	// 改資料
	public void updateDataById(Updatebean m) throws SQLException {
		String sqlStr = "Update record set pcount = ?"
				+ " where record_id = ? and PID = ?" ;
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1, m.getPcount());
		preState.setInt(2, m.getRecord_id());
		preState.setInt(3, m.getPid());
		System.out.println("m.getPcount()="+m.getPcount());
		System.out.println("m.getRecord_id()="+m.getRecord_id());
		System.out.println("m.getPid()="+m.getPid());
		
	
		int count = preState.executeUpdate();
		System.out.println("更改成功");
		System.out.println("Update count : " + count);
		preState.close();


	}



}
