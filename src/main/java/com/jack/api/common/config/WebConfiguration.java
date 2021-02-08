package com.jack.api.common.config;

import com.jack.api.common.interceptors.NetworkInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public NetworkInterceptor networkInterceptor(){
        return new NetworkInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(networkInterceptor()).addPathPatterns("/get/**");
    }
}
