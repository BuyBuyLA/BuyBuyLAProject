package buybuyla.action.member_25;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/ch04/ex03/register0403.do")
public class Register0403 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();
        request.setAttribute("ErrorMsgKey", errorMsg); 
		// 1. 讀取使用者輸入資料
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String name = request.getParameter("userName");
		String eMail = request.getParameter("eMail");
		String tel = request.getParameter("tel");
		String expericnceStr = request.getParameter("experience");
		// 2. 進行必要的資料轉換
		int experience = 0;
		try {
			experience = Integer.parseInt(expericnceStr.trim());
		} catch (NumberFormatException e) {
			errorMsg.add("使用Java經驗格式錯誤，應該為整數");
		}
		// 3. 檢查使用者輸入資料
		if (userId == null || userId.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.add("密碼欄必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.add("姓名欄必須輸入");
		}
		if (eMail == null || eMail.trim().length() == 0) {
			errorMsg.add("EMail欄必須輸入");
		}
		if (tel == null || tel.trim().length() == 0) {
			errorMsg.add("電話號碼欄必須輸入");
		}
		if (experience < 0) {
			errorMsg.add("使用Java經驗應該為正整數或 0 ");
		}
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
		//4.
		WebApplicationContext ctx=WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		IRegisterService rs=ctx.getBean(IRegisterService.class);
		
		
		//要IOC 控制反轉了  改成上面
		// 4. 進行 Business Logic 運算
//		IRegisterService rs = new RegisterService();
		try {
			if (rs.existsByMemberId(userId)) {
				errorMsg.add("該代號 (" +  userId  + ") 已經存在，請換新的代號");
			} else {
				Member mem = new Member(userId, password, name, eMail, tel,	experience);
				rs.save(mem);
			}
		} catch(Exception ex) {
			errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + ex.getMessage());
			ex.printStackTrace();
		}	
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("userIdKey", userId);
		if (errorMsg.isEmpty())	{			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			return ; 
		}  else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
     }
}   