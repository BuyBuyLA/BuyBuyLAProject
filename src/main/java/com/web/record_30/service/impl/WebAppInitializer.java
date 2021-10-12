package com.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//所有程式都交由分派器
		
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] {characterEncodingFilter};
	}

	
}
