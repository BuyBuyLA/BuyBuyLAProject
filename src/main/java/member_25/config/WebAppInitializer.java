package member_25.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//import com.sun.org.apache.xpath.internal.operations.String;


//Servlet 3.0後就不需要web.xml
//而轉提供一個介面ServletContainerInitializer
//Tomcat啟動時會在類別中找到有實作這個介面的類別配置該應用系統

//3.2 AbstractAnnotationConfigDispatcherServletInitializer
//任何有繼承這個類別的都會貝Tomcat發現並配置系統
//可以註冊過濾器(Filter)，監聽器(Listener)，Servlet等，
//就像原本在web.xml中所做的事一樣。


//AbstractAnnotationConfigDispatcherServletInitializer 幫建web版的IOC容器
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//傳回提供組態資訊
		//提供Service/Dao功能之Bean的組態資訊，
		//例如提供DataSource類別、交易管理器(Transaction managers)、Hibernate的SessionFactory類別等。
		return new Class[] {RootAppConfig.class};
	}

	@Override   
	protected Class<?>[] getServletConfigClasses() {
		//供組態資訊
		//Bean的組態資訊，
		//告訴Spring MVC那些套件下有控制器類別、檔案上傳時
		//會用到的類別、哪些路徑下有靜態檔案，
		//這些靜態檔案直接由容器傳回給客戶端而不要交給控制器去處理等等。
		return new Class[] {WebAppConfig.class};
	}

	@Override    //到底哪些請求要交給Spring MVC的分派器(DispatcherServlet)處理
	protected String[] getServletMappings() {
		
		return new String[] {"/"};  // 表示所有請求都要拉 {"/"}
	}

	@Override
	protected Filter[] getServletFilters() {  //解決亂碼問題 ->UTF-8
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] {characterEncodingFilter};
	}
	
	
	

}
