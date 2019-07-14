package com.angelo.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@EnableWebMvc
@Configuration
@ComponentScan("com.angelo.mvc")
public class AppConfig implements WebMvcConfigurer {

    // 方法一 通过javaConfig进行配置视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

//    // 方法二 实现WebMvcConfigurer接口, 并加上@EnableWebMvc, 最终此处还有点问题，特此备注
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/",".jsp");
//    }

    //

    /**
     * 使用 Apache Commons FileUpload
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        return new CommonsMultipartResolver();
    }

    /**
     * 使用 Servlet 3.0
     * 需在Servlet 注册中加入MultipartConfigElement，详情见AppInitializer
     */
//    @Bean("multipartResolver")
//    public StandardServletMultipartResolver  standardServletMultipartResolver() {
//        return new StandardServletMultipartResolver();
//    }
}
