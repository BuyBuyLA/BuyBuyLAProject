package com.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.web.member_25.controller.AuthInterceptor;

@Configuration 
@EnableWebMvc //啟動web mvc
//@ComponentScan({"com.web.store.connfig","com.web.store.controller","com.web.utils"})
@ComponentScan("com.web")
public class WebAppConfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
		//視圖邏輯器
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/"); //前導字
		resolver.setSuffix(".jsp"); //\
		return resolver;
	}
	
	@Bean
	//方法名稱不能更改
	public MessageSource messageSource() {
		ResourceBundleMessageSource rbms= new ResourceBundleMessageSource();
		rbms.setBasename("messages");
		return rbms;
	}
	
	@Override 
	//資源處理器註冊(不交給分派器)，css樣式表
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/css/**") //**不拘束路徑怎麼寫(可多層次/)
	             .addResourceLocations("/WEB-INF/views/css/");
	     registry.addResourceHandler("/image/**")
	             .addResourceLocations("/WEB-INF/views/images/");
	} 
	
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}
	
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //註冊自己的攔截器並設定攔截的請求路徑   //攔截登入狀態的session
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**") //攔截的路徑  /**攔截所有 /*一層
                .excludePathPatterns(""); //排除的路徑
    }
	
	
}
