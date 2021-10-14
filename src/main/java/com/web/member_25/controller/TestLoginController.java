package com.web.member_25.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.member_25.model.membershipInformationBean;
import com.web.member_25.service.MemberService;

@Controller
@SessionAttributes("loginSession")
public class TestLoginController {
	
	MemberService memberService;
	
	
	@Autowired 
	public TestLoginController(MemberService memberService) {
		this.memberService = memberService;
	}


	@GetMapping("/")
	public String indexDefault() {
		System.out.println("回首頁");
		return "tryIndex";
	}
	
	
	
	@GetMapping("/try/index")
	public String index(
			@ModelAttribute("loginSession") membershipInformationBean mb,
			Model model) {
		System.out.println("login後回首頁GetMapping");
		membershipInformationBean mb2=new membershipInformationBean();
		mb2.setUserEmail(mb.getUserEmail());
		mb2.setUserPwd(mb.getUserPwd());
		model.addAttribute("loginSession",mb2);
		System.out.println("首頁的getmapping ----------->getUserEmail ="+mb.getUserEmail());
		
		
		return "tryIndex";
	}
	
	@PostMapping("/try/index")
	public String processIndex(
			@ModelAttribute("loginSession") membershipInformationBean mb,
			Model model) {
		System.out.println("有進到POST Index哦-------->UserEmail "+mb.getUserEmail());
		System.out.println("有進到POST Index哦-------->");
		
		return "tryIndex";
	}
	
	@GetMapping("/try/add")
	public String trySignUp(Model model) {
//		MemberBean mb=new MemberBean();
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		mb.setUserEmail("c123@gmail.com");
		mb.setUserPwd("c123456");
		mb.setUserPhone("09123456");
		model.addAttribute("loginBeanDefault",mb);
		return "trySignUpPage";
	}

	@PostMapping("/try/add")
	public String processtrySignUp(
			@ModelAttribute("loginBeanDefault") membershipInformationBean mb,
			BindingResult result,   //老爸 is errors (表單有任何錯誤都放到這裡)	
			Model model
	) {
		
		//-------------------------------------------
		//檢查有沒有違法欄位
		 String[] suppressedFields = result.getSuppressedFields();
		    if (suppressedFields.length > 0) {
		      throw new RuntimeException("嘗試傳入不允許的欄位: " + 
		    //把陣列裡面的元素用,隔開並轉成字串
		      StringUtils.arrayToCommaDelimitedString(suppressedFields));
		      
		 }
		  //--------------------------------------  
		    System.out.println("suppressedFields---->"+suppressedFields);
		    System.out.println("suppressedFields 專字串後---->"+StringUtils.arrayToCommaDelimitedString(suppressedFields));
		System.out.println("-------> mb = "+mb);
		System.out.println("---->mb.ID="+mb.getId());	
		System.out.println("---->mb.ID="+mb.getUserEmail());	
		
		int loginResult=0;
		loginResult=	memberService.overlappedAccount(mb.getUserEmail());
		if (loginResult==1 ||loginResult==3) {
			System.out.println("帳號重複  ----->");
			
			return "trySignUpPage";
	
		}else if (loginResult==2) {
			System.out.println("無人使用此帳號 已註冊  ----->");
			memberService.save(mb);	
			return "tryIndex";
		}
		
		return  "trySignUpPage";
	}
	


		@GetMapping("/try/login")
		public String tryLogin(Model model) {
			
//			membershipInformationBean mb=new membershipInformationBean();
//			mb.setUserEmail("");
//			mb.setUserPwd(""); 
//			model.addAttribute("loginSession",mb);
			 model.addAttribute("loginSession",new membershipInformationBean());
			return "tryLoginPage";
		}
		
		@PostMapping("/try/login")
		public String processtryLogin(
				@ModelAttribute("loginSession") membershipInformationBean mb,
//				
//				@RequestParam String userEmail,
//				@RequestParam String userPwd,
				BindingResult result,
				RedirectAttributes redirectAttributes,
				Model model) {
			
			//-------------------------------------------
			//檢查有沒有違法欄位
			 String[] suppressedFields = result.getSuppressedFields();
			    if (suppressedFields.length > 0) {
			      throw new RuntimeException("嘗試傳入不允許的欄位: " + 
			    //把陣列裡面的元素用,隔開並轉成字串
			      StringUtils.arrayToCommaDelimitedString(suppressedFields));
			 }
			
			
			System.out.println("==========進入processMemberLogin=====================");
			membershipInformationBean mb2=new membershipInformationBean();
			
			int loginResult=0; //0錯誤  1成功 2無帳號 3重複帳號(除了自己+的應該不會出現這個可能)
			
			String userEmail=null,userPwd=null;
			userEmail=mb.getUserEmail();
			userPwd=mb.getUserPwd();
			System.out.println("登入表單的userEmail ======>"+userEmail);
			loginResult=	memberService.login(userEmail, userPwd);
			
			System.out.println("login結果 = "+memberService.login(userEmail, userPwd));
			
			if (loginResult==1) {
				System.out.println("登入成功 userEmail  ----->"+userEmail);
				mb2.setUserEmail(userEmail);
				mb2.setUserPwd(userPwd); 
				model.addAttribute("loginSession",mb2);
				return "redirect:/try/index";  //登入成功
				
				
			}else if (loginResult==2) {
				System.out.println("查無帳號  ----->");
			}else if (loginResult==3) {
				System.out.println("帳號重複  ----->");
			}
				
			return "tryLoginPage";
		}
		
		
		@RequestMapping("/try/logout")
	    public String tologout(HttpSession session,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus) {
	        session.removeAttribute("loginSession");
//	        session.removeAttribute("date");
	        System.out.println("logout:"+session.getAttribute("loginSession"));
	        sessionStatus.setComplete(); 
	        System.out.println("已清除 登入狀態loginSession");
	        return "redirect:/";   //回乾淨首頁成功 讚
	    }
		
		
		
		
		

}
