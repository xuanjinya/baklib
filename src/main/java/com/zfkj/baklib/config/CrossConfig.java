package com.zfkj.baklib.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 配置允许跨域访问
// addMapping：允许的请求路径
// allowedOrigins：允许的域名ip
// allowedHeaders：允许的请求头
// allowedMethods：允许的方法
// maxAge：有效时间
@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(30 * 1000);
    }
}
