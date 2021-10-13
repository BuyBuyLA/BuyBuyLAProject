package com.web.member_25.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.member_25.model.membershipInformationBean;
import com.web.member_25.service.MemberService;



//處裡前端請求的地方
//控制器會呼叫service


@Controller
public class MemberController {
	
	//控制器會呼叫service
    //現在直接@Autowired代替(spring mvc後永遠都見不到下面那行了)
//之前的寫法視webApplication ctx+getBean 	
	MemberService memberService;
	
	@Autowired 
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/")  //視圖傳回
	public String index000() {
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
	public String processMemberLogin(
			@ModelAttribute("loginSessionBeanDefault") membershipInformationBean mb2,
			Model model	
		) {
		System.out.println("進入processMemberLogin");
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		System.out.println("Login ->userEmail="+mb2.getUserEmail());
		
		String userEmail=mb2.getUserEmail();
		String userPwd=mb2.getUserPwd();
		

		int loginResult=0;
		
		loginResult=	memberService.login(userEmail, userPwd);
		System.out.println("login結果 = "+memberService.login(userEmail, userPwd));
		
		
		if (loginResult==1) {
			System.out.println("登入成功");
			
			System.out.println("登入成功的 userEmail = "+userEmail);
			System.out.println("登入成功的 userPwd = "+userPwd);
			System.out.println("開始------------------->findByEmail ");
			mb.setUserEmail(userEmail);
			mb.setUserPwd(userPwd);
			model.addAttribute("loginSessionBean",mb);
			return "index";
		}else if (loginResult==2) {
			System.out.println("沒帳號拉");
			return "signupPage";
		}else if (loginResult==3) {
			System.out.println("帳號重複");
			return "loginPage";
		}
		
		System.out.println("userEmail = "+userEmail);
		System.out.println("userPwd = "+userPwd);
		System.out.println("開始------------------->findByEmail ");
		
		System.out.println("============登入失敗===============");
		return "loginPage";
	}
	
	
	@GetMapping("/member/update")
	public String getMemberUpdate(
			@ModelAttribute("loginSessionBean") membershipInformationBean mb2,
	
			Model model) {
		membershipInformationBean mb=new membershipInformationBean();
		//設定預設值
		  //順序 model (不用set)- 下一個post要set才會存進去(縣市再頁面) 
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