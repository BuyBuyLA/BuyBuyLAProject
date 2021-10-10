package member_25.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//import ch01.model.MemberBean;
//import ch01.service.MemberService;

import member_25.model.MemberBean;
import member_25.service.MemberService;

@WebServlet("/WEB-INF/views/member_25/findMember.do")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");//注意大小寫
		int pk = Integer.parseInt(key);
//		MemberService ms = new MemberServiceImpl();
//		ServletContext sc = getServletContext();
//		WebApplicationContext ctx = WebApplicationContextUtils
//										.getWebApplicationContext(sc);
		WebApplicationContext ctx = WebApplicationContextUtils
				                      .getWebApplicationContext(getServletContext());
		MemberService ms = ctx.getBean(MemberService.class);
		MemberBean mb = ms.findById(pk);
		request.setAttribute("mb", mb);
		RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
