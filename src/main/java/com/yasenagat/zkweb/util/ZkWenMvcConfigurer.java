package com.yasenagat.zkweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
public class ZkWenMvcConfigurer  implements WebMvcConfigurer {

	@Autowired
	private LocaleChangeInterceptor localInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localInterceptor);
        // 拦截/freemarker后路径
     	//registry.addInterceptor(new JoeInterceptor()).addPathPatterns("/freemarker/**");
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/zk","/zkcfg");
    }
    @Override
   	public void addViewControllers(ViewControllerRegistry registry) {
       	registry.addViewController("/").setViewName("home");
   	}
       
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");//.addResourceLocations("classpath:/resources/templates/");//,"classpath:/resources/webapp/WEB-INF/views/");
    	//registry.addResourceHandler("/**");
    	//registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
    }
}
