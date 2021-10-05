package buybuyla.action.member_25;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch04.ex03.model.IRegisterService;
import ch04.ex03.model.Member;
import ch04.ex03.model.RegisterService;
@WebServlet("/ch04/ex04/queryAllMembers.do")
public class QueryAllMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			WebApplicationContext ctx=WebApplicationContextUtils
					.getRequiredWebApplicationContext(getServletContext());
			IRegisterService rs=ctx.getBean(IRegisterService.class);
			
			
			//要IOC 控制反轉了  改成上面			
//	     	IRegisterService  rs = new RegisterService();   
	     	List<Member>  coll = rs.findAll();
	     	request.setAttribute("AllMembers", coll);
	     	RequestDispatcher rd = request.getRequestDispatcher("showAllMembers.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
     	return ; 
	}
}
