package member_25.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration     //組態黨設定
@EnableWebMvc     //把請求交給以@Controller修飾的POJO類別
@ComponentScan("member_25") //通知Spring框架要掃描哪些套件，
								//且套件一定要有@Component那四個相關註釋
								//不然會找不到
public class WebAppConfig implements WebMvcConfigurer { 
	
	//通知spring框架去哪裡找JSP網頁
	//@GetMapping定義路徑
	@Bean  //視圖解析器  
	public ViewResolver internalResouViewResolver() {
		//內部支援解析視圖器(帝5布)
		//視圖解析器->會用依照『字首+視圖代名+字尾』的公式
		//如得到 "/WEB-INF/views/XXXX.jsp"，
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/"); //  /WEB-INF/前導字串 大家通常都會這樣用 
												//   views/一定要有/ 不然一定會出錯 因為變成(/WEB-INF/viewsjsp)
		resolver.setSuffix(".jsp");  //後綴字  尾巴會加的字串
		
		
		return resolver;
	}
		//只要在遊覽器中更改預設語言這邊就會自動改變語言(webappconfig-jsp-properties)
	@Bean   //把頁面的的語言系統替換 預設:messages 
	public MessageSource messageSource() { //方法名稱不能改
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");
		return rbms;
		
	}
	
	//原先如果只在JSP家引入CSS會因為請求沒人處理(spring中dispacher控管所有請情)
	//而找不到 
	//因此要自己去複寫他的父類做配置
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/css/**")  //從下面那行的css往下找
	             .addResourceLocations("/WEB-INF/views/css/");
	     registry.addResourceHandler("/image/**")
	             .addResourceLocations("/WEB-INF/views/images/");
	} 
	
	//上傳圖片
	@Bean   //spring處裡檔案上傳的類別
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}

}
