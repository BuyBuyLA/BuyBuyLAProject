package member_25.controller;

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

import member_25.model.MemberBean;
import member_25.model.membershipInformationBean;
import member_25.service.MemberService;

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
		mb.setUserEmail("a@gmail.com");
		mb.setUserPwd("a@gmail.com");
		mb.setUserPhone("09111111");
		mb.setIdentification("一般會員");
	
		model.addAttribute("membershipInformationBean",mb);
		return "MemberForm";
		
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
		 return "insertMemberSuccess";
	}
	//下拉選單(companyList+categoryList) 前置作業@ModelAttribute
//			@ModelAttribute("IdentificationList") 
//			public List<membershipInformationBean> getIdentificationList() {
//			
//			    return memberService.getIdentificationList();
//			}
			
			
			//前置器
			//所有控制器有方法執行時  都會做@ModelAttribute的這個方法
			//通常用在一些方法執行前做的前置動作
//			@ModelAttribute("house")  //視圖傳回
//			public String m1(Model model) {
//				System.out.println("前置表單執行中.............");
////				
////				//加入productService
////				List<String>list2=productService.getAllCategories();
////				List<String>list=Arrays.asList("春","夏","秋","冬");
//////				model.addAttribute("seanson",list);				
//				return null;  //用return 寫法  等同上面
//			}

	

}
