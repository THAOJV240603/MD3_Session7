package com.ra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Để cấu hình MVC
@Configuration //Chỉ định lớp này dùng để cấu hình (Định nghĩa được Bean)
@EnableWebMvc //Sử dụng cấu hình MVC (bao gồm 3 thành phần model, view, controller)
@ComponentScan (basePackages = "com.ra") //Quét các packages và tự động phát hiện component (@Controller, @Service, @Repository, @Component)
public class AppConfig implements WebMvcConfigurer {
    //Định nghĩa Bean
    //Cấu hình view: jsp
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //Bean multipartResolver: quy định kích thước tối đa được gửi lên server là bao nhiêu
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(52428800); //= 50MB
        return resolver;
    }

    //Cấu hình đường dẫn để người dùng có thể xem file tải lên
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Patterns: định dạng /uploads/abc.jpg
        //Khớp với đường dẫn /uploads/abc.jpg trên server
        //registry.addResourceHandler("/img/**").addResourceLocations("/uploads/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
    }

}
