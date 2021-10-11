package com.web.member_25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.member_25.model.MemberBean;
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
	
	@GetMapping("/member/add")
	public String getAddNewMember(Model model) {
		MemberBean mb=new MemberBean();
		//設定預設值
		mb.setId("21");
		mb.setName("Cathy");
		model.addAttribute("MemberBean",mb);
		return "addMember";
		
	}
	

	

}
