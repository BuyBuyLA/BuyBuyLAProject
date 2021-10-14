package com.web.member_25.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.member_25.model.membershipInformationBean;
import com.web.member_25.service.MemberService;



//處裡前端請求的地方
//控制器會呼叫service


@Controller
//應該是要可以用的
//@SessionAttributes(value = "loginSessionBean", types = {membershipInformationBean.class})  
public class MemberController {
	
	//控制器會呼叫service
    //現在直接@Autowired代替(spring mvc後永遠都見不到下面那行了)
//之前的寫法視webApplication ctx+getBean 	
	MemberService memberService;
	
	@Autowired 
	public MemberController(
//			Model model,
			MemberService memberService) {
		
		this.memberService = memberService;
		
//		membershipInformationBean mb=new membershipInformationBean();	
//		mb.setUserEmail("Hi 歡迎光臨");
//		mb.setUserPwd("");
//		model.addAttribute("loginSessionBean2",mb);
	}
	
	@GetMapping("/index")  //視圖傳回
	public String index000(
			@ModelAttribute("loginSessionBean") membershipInformationBean mb2,
//			@RequestParam("userEmail") String userEmail,
			RedirectAttributes redirectAttributes,  //RedirectAttributes重新導向的方法
			Model model) {
		System.out.println("===========mb2.getUserEmail()"+
							mb2.getUserEmail()+
							"===============");
		membershipInformationBean mb=new membershipInformationBean();	
		if(mb2.getUserEmail()!=null)
		{
			System.out.println("--------------->login後回傳的loginSessionBean  (if ! = null)  = "+mb2.getUserEmail());
		mb.setUserEmail(mb2.getUserEmail());
		mb.setUserPwd(mb2.getUserPwd());
		model.addAttribute("loginSessionBean2",mb);
		
//		redirectAttributes.addFlashAttribute("loginSessionBeanFromIndex", mb);
//		ModelAndView mv = new ModelAndView("redirect:/index2"); 
		return "index";
		}else {
			mb.setUserEmail("Hi 歡迎光臨");
			mb.setUserPwd("");
			model.addAttribute("loginSessionBean2",mb);
			System.out.println("--------------->login後回傳的loginSessionBean  (if = null)  = "+mb2.getUserEmail());
			
		}
//		redirectAttributes.addFlashAttribute("loginSessionBeanFromIndex", mb);
//		ModelAndView mv = new ModelAndView("redirect:/index2"); 
		return "index";
		
	}
	
	@PostMapping("index")  //視圖傳回
	public String processindex000(
			@ModelAttribute("loginSessionBean2") membershipInformationBean mb2,
//			@RequestParam("userEmail") String userEmail,
			Model model) {
		membershipInformationBean mb=new membershipInformationBean();	
		mb.setUserEmail(mb2.getUserEmail());
		mb.setUserPwd(mb2.getUserPwd());
		model.addAttribute("loginSessionBean3",mb);
System.out.println("=======================================");
		System.out.println("-------index有做到post方法-------->login後回傳的loginSessionBean (process) = "+mb2.getUserEmail());
		return "index";
	}
	

	
	@GetMapping("/member/add")
	public String getAddNewMember(Model model) {
//		MemberBean mb=new MemberBean();
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		mb.setUserEmail("a123@gmail.com");
		mb.setUserPwd("a123456");
		mb.setUserPhone("0981981721");
		mb.setIdentification("一般會員");
	
		model.addAttribute("membershipInformationBean",mb);
		return "signupPage";
	}
	
	@PostMapping("/member/add")
	public String processAddNewMember(
			@ModelAttribute("membershipInformationBean") membershipInformationBean mb,
			BindingResult result   //老爸 is errors (表單有任何錯誤都放到這裡)		
	) {
		
		//------------------------------------------
		//檢查有沒有違法欄位
		 String[] suppressedFields = result.getSuppressedFields();
		    if (suppressedFields.length > 0) {
		      throw new RuntimeException("嘗試傳入不允許的欄位: " + 
		    //把陣列裡面的元素用,隔開並轉成字串
		      StringUtils.arrayToCommaDelimitedString(suppressedFields));
		 }
		  //--------------------------------------  
		System.out.println("-------> mb = "+mb);
		System.out.println("---->mb.ID="+mb.getId());	
		memberService.save(mb);	
		System.out.println("************return 之前");
		 return "InsertMemberSuccess";
	}
	
	@GetMapping("/member/login")
	public String getMemberLogin(Model model) {
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		mb.setUserEmail("b123@gmail.com");
		mb.setUserPwd("b123456");
		model.addAttribute("loginSessionBeanDefault",mb);
		return "loginPage";
	}
	
	@PostMapping("/member/login")
	public ModelAndView processMemberLogin(
			@ModelAttribute("loginSessionBeanDefault") membershipInformationBean mb2,
			Model model,
			RedirectAttributes redirectAttributes,
			HttpSession session   //用作攔截
		) {
		System.out.println("==========進入processMemberLogin=====================");
		membershipInformationBean mb=new membershipInformationBean();
		
		System.out.println("processMemberLogin ->userEmail="+mb2.getUserEmail());		
		String userEmail=mb2.getUserEmail();
		String userPwd=mb2.getUserPwd();
		

		int loginResult=0;
		
		loginResult=	memberService.login(userEmail, userPwd);
		System.out.println("login結果 = "+memberService.login(userEmail, userPwd));
		
		
		if (loginResult==1) {
			System.out.println("登入成功");
			
			//============攔截器測試==================
			session.setAttribute("loginUser", userEmail);
            session.setAttribute("uid",userPwd);
			
            
			
			
			System.out.println("登入成功的 userEmail = "+userEmail);
			System.out.println("登入成功的 userPwd = "+userPwd);
			System.out.println("開始------------------->findByEmail ");
			mb.setUserEmail(userEmail);
			mb.setUserPwd(userPwd);
//			model.addAttribute("loginSessionBean",mb);
			System.out.println("-----------"+mb.getUserEmail());
			redirectAttributes.addFlashAttribute("loginSessionBean", mb);
			ModelAndView mv = new ModelAndView("redirect:/index"); 
			return mv;
		}else if (loginResult==2) {
			System.out.println("沒帳號拉");
			ModelAndView mv = new ModelAndView("redirect:/loginPage"); 
			return mv;
		}else if (loginResult==3) {
			System.out.println("帳號重複");
			ModelAndView mv = new ModelAndView("redirect:/loginPage"); 
			return mv;
		}
		
		System.out.println("userEmail = "+userEmail);
		System.out.println("userPwd = "+userPwd);
		System.out.println("開始------------------->findByEmail ");
		
		System.out.println("============登入失敗===============");
		ModelAndView mv = new ModelAndView("redirect:/loginPage"); 
		return mv;
	}
	
	
	//登出
	@GetMapping("/member/logout")
    public String execute(  		
			Model model,
    		HttpSession session){
		
        session.invalidate();
        membershipInformationBean mb=new membershipInformationBean();
        mb.setUserEmail("b123@gmail.com");
		mb.setUserPwd("b123456");
		model.addAttribute("loginSessionBeanDefault",mb);
		System.out.println("登出囉!");
        
        
        return "loginPage";
    }
	
	
	@GetMapping("/member/update")
	@PostMapping("/member/update")  //收到post請求時也會做
	public String getMemberUpdate(
			@ModelAttribute("loginSessionBean2") membershipInformationBean mb2,
			
			Model model) {
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		  //順序 model (不用set)- 下一個post要set才會存進去(縣市再頁面) 
		System.out.println("update初始抓登入的bean的值 EMAIL = "  +mb2.getUserEmail());
		mb.setUserEmail(mb2.getUserEmail());
		mb.setUserName(mb2.getUserName());
		model.addAttribute("loginSessionBeanDefault",mb);
		
		return "member_Ui";
	}
	
	
	@PostMapping("/member/update")
	public String processMemberUpdate(
			@ModelAttribute("loginSessionBeanDefault") membershipInformationBean mb2,
		
			@RequestParam("userName") String userName,
			@RequestParam("userPhone") String userPhone,
			@RequestParam("userGender") String userGender,
			Model model
			) {
		membershipInformationBean mb=new membershipInformationBean();
		
		
		System.out.println(" userGender= "+userGender);
		//設定預設值
	
//		mb.setUserPhone(userGender);
//		model.addAttribute("updateBean",mb);
////		
		return "member_Ui";
	}
	
	

}