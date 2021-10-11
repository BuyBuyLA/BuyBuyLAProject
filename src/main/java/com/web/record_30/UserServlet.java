package com.web.record_30;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import HibernateHW.util.HibernateUtil;
import manage.Record;
import manage.RecordDao;
import mvc.bean.loginBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("select") != null)
			gotoSelect(request, response);
		else if (request.getParameter("delete") != null)
			gotoDelete(request, response);
		else if (request.getParameter("update") != null)
			gotoUpdate(request, response);
	}

	public void gotoSelect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String user;
//		user = request.getParameter("user").trim();
		
		

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			UserDao userDao = UserDaoFactory.getUserDao();
			userDao.createConn();
			// 把stu bean抓回來
//				   SelectBean studentData = (SelectBean) request.getSession(true).getAttribute("user");
			//抓user帳號回來
			 loginBean emailBean = (loginBean) request.getSession(true).getAttribute("reg_student");
			 String emailString=emailBean.getEmailLogin();
			 System.out.println("emailString="+emailString);
			 

//				SelectBean select = new SelectBean(user);
//				System.out.println("user=" + user);
//			 
			userDao.findDataByDistrict(emailString);
			ArrayList<Select2bean> ss = userDao.findDataByDistrict(emailString);

			for (Select2bean s : ss) {
				if (s != null)
					System.out.print(String.format("ss = %d,%d,%s,%d,%s,%s,%d", s.getRecord_id(), s.getPid(),
							s.getP_name(), s.getP_price(), s.getBuy_time(), s.getUserEmail(), s.getPcount()));
//						   System.out.println("ss = "+ss[i]);
			}
//				      Select2bean select2=new Select2bean(ss);
			System.out.println("Get some SQL commands done!");
//			          request.getSession(true).invalidate();
			request.getSession(true).setAttribute("select2", ss);
			request.getRequestDispatcher("./Select2.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("sonething wrong with 查詢");

			e.printStackTrace();
		}

	}

	public void gotoDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid;
		pid = request.getParameter("dpid").trim();
		int PID = Integer.parseInt(pid);
		Deletebean delete = new Deletebean(PID);
		request.getSession(true).setAttribute("PID", PID);
		try {

			// 連線
			UserDao userDao = UserDaoFactory.getUserDao();
			userDao.createConn();
			// 把stu bean抓回來
//			   SelectBean studentData = (SelectBean) request.getSession(true).getAttribute("user");
			userDao.deleteById(PID);

			System.out.println("Get some SQL commands done!");
			request.getSession(true).invalidate();
			request.getRequestDispatcher("/delete2.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("sonething wrong");

			e.printStackTrace();
		}

	}

	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("開始動作");
		String rid;
		String pid;
		String cnt;
		rid = request.getParameter("uprid").trim();
		pid = request.getParameter("uppid").trim();
		cnt = request.getParameter("upcnt").trim();
		int RID = Integer.parseInt(rid);
		int PID = Integer.parseInt(pid);
		int CNT = Integer.parseInt(cnt);
		System.out.println("RID=" + RID);
		System.out.println("PID=" + PID);
		System.out.println("CNT=" + CNT);
		Updatebean update = new Updatebean(RID, PID, CNT);
		request.getSession(true).setAttribute("update", update);
		try {

			// 連線
			UserDao userDao = UserDaoFactory.getUserDao();
			userDao.createConn();
			// 把stu bean抓回來
			Updatebean studentData = (Updatebean) request.getSession(true).getAttribute("update");
			userDao.updateDataById(studentData);

			System.out.println("Get some SQL commands done!");
			request.getSession(true).invalidate();
			request.getRequestDispatcher("/update2.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("sonething wrong");

			e.printStackTrace();
		}

	}
}
