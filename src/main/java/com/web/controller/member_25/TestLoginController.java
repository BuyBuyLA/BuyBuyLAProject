package com.web.controller.member_25;

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
@SessionAttributes({"loginSession","memberUiDefault","managerSession"})
public class TestLoginController {
	
	MemberService memberService;
	
	
	@Autowired 
	public TestLoginController(MemberService memberService) {
		this.memberService = memberService;
	}


//	@GetMapping("/zxczc")   //改
//	public String indexDefault() {
//		System.out.println("回首頁");
//		return "member_25/tryIndex";
//	}
	
	
	
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
		
		
		return "cart_30/TotalHome";
	}
	
	@PostMapping("/try/index")
	public String processIndex(
			@ModelAttribute("loginSession") membershipInformationBean mb,
			Model model) {
		System.out.println("有進到POST Index哦-------->UserEmail "+mb.getUserEmail());
		System.out.println("有進到POST Index哦-------->");
		
		return "cart_30/TotalHome";
	}
	
	@GetMapping("/try/add")
	public String trySignUp(Model model) {
//		MemberBean mb=new MemberBean();
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		mb.setUserEmail("c123@gmail.com");
		mb.setUserPwd("c123456");
		mb.setUserPhone("09123456");
		mb.setIdentification("member");
		model.addAttribute("loginBeanDefault",mb);
		return "member_25/trySignUpPage";
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
		System.out.println("---->mb.getIdentification="+mb.getIdentification());	
		
		int loginResult=0;
		loginResult=	memberService.overlappedAccount(mb.getUserEmail());
		if (loginResult==1 ||loginResult==3) {
			System.out.println("帳號重複  ----->");
			
			return "member_25/trySignUpPage";
	
		}else if (loginResult==2) {
			System.out.println("無人使用此帳號 已註冊  ----->");
			memberService.save(mb);	
			return "cart_30/TotalHome";
		}
		
		return  "member_25/trySignUpPage";
	}
	


		@GetMapping("/try/login")
		public String tryLogin(Model model) {
			
//			membershipInformationBean mb=new membershipInformationBean();
//			mb.setUserEmail("");
//			mb.setUserPwd(""); 
//			model.addAttribute("loginSession",mb);
			
			 model.addAttribute("loginSession",new membershipInformationBean());
			return "member_25/tryLoginPage";
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
				
				int id=0; Boolean isMamber=true;
				id=memberService.findIdByEmail(userEmail);  //ccccccccccccc
				isMamber= memberService.memberOrManager(id);   //判斷是使用者還是管理者
				System.out.println("isMamber------------>>管理者?----->"+isMamber);
				if (isMamber==false) {				
					mb2.setUserEmail(userEmail);
					mb2.setUserPwd(userPwd); 
					model.addAttribute("managerSession",mb2);
					return "redirect:/try/manage";
				}
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
				
			return "member_25/tryLoginPage";
		}
		
		
		@RequestMapping("/try/logout")
	    public String tologout(HttpSession session,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus) {
	        session.removeAttribute("loginSession");
	        session.removeAttribute("memberUiDefault");
	        session.removeAttribute("managerSession");
	        System.out.println("logout:"+session.getAttribute("loginSession"));
	        sessionStatus.setComplete(); 
	        System.out.println("已清除 登入狀態loginSession+managerSession+memberUiDefault");
	        return "redirect:/";   //回乾淨首頁成功 讚
	    }
		
		@GetMapping("/try/member_Ui")
		public String tryMemberUpdate(
				@ModelAttribute("loginSession") membershipInformationBean mb,
				Model model) {
			System.out.println("membershipInformationBean --getUserEmail----->"+mb.getUserEmail());
			membershipInformationBean mb2=new membershipInformationBean();

			String userEmail=mb.getUserEmail();		
			
			//how to find id
		int id=0;
		id=memberService.findIdByEmail(userEmail);  //ccccccccccccc
		System.out.println("=========getid-======================="+mb2.getId());
		
		System.out.println("*--------user pk id---------------------------->"+id);
			//-findID
			mb2=memberService.findById(id);
			
			System.out.println("getUserEmail --getMemberData2--><--->"+mb2.getUserEmail());
			System.out.println("getUserPwd --getMemberData2--><--->"+mb2.getUserPwd());
			 model.addAttribute("memberUiDefault",mb2);
			return "member_25/tryMember_Ui";
		}
		
		@PostMapping("/try/member_Ui")
		public String tryProcessMemberUpdate(
				@ModelAttribute("memberUiDefault") membershipInformationBean mb,
//				@RequestParam String userEmail,
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
			System.out.println("==========進入tryProcessMemberUpdate=====================");
			membershipInformationBean mb2=new membershipInformationBean();

				mb2.setUserEmail(mb.getUserEmail());
				mb2.setUserPwd(mb.getUserPwd()); 
				mb2.setAddress(mb.getAddress());
				mb2.setHead_shot(mb.getHead_shot());
				mb2.setUserGender(mb.getUserGender());
				mb2.setUserPhone(mb.getUserPhone());
				mb2.setUserName(mb.getUserName());
				mb2.setIdentification(mb.getIdentification());
				model.addAttribute("memberData",mb2);
			
			memberService.update(mb2);
				System.out.println("update success");
			return "member_25/tryMember_Ui";
		}
		
		@GetMapping("/try/delete")
		public String tryMemberDelete(
				@ModelAttribute("loginSession") membershipInformationBean mb,
				HttpSession session,HttpServletRequest request,HttpServletResponse response,SessionStatus sessionStatus
				,Model model) {
			System.out.println("membershipInformationBean --tryMemberDelete----->");
			
			memberService.deleteByName(mb.getUserEmail());
			
			tologout(session, request, response, sessionStatus);
			return "redirect:/";
		}
		
		
		
		
		//管理者專用區
		
		@GetMapping("/try/manage")
		public String manager(
				@ModelAttribute("managerSession") membershipInformationBean mb,
				Model model) {
			System.out.println("managerSession --manager----->"+mb.getUserEmail());
			
			
			return "manager_Ui";
		}
		
		
		
		
		
		
		

		

}
