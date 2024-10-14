package com.ra.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //Cấu hình gốc: ko liên quan đến MVC
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //Cấu liên quan tới MVC
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //Xử lý UTF-8
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[]{filter};
        //CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //characterEncodingFilter.setEncoding("UTF-8");
        //return new Filter[]{characterEncodingFilter};
    }
}
