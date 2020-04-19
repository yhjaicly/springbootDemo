package com.ahai.face.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FaceConfig implements WebMvcConfigurer {
//路径请求配置页面
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/success.html").setViewName("success");
                registry.addViewController("/404.html").setViewName("404");
                registry.addViewController("/uploadImage.html").setViewName("uploadImage");
                registry.addViewController("login.html").setViewName("login");
                registry.addViewController("successGetPhoto.html").setViewName("successGetPhoto");
            }
        };
        return configurer;
    }

}
