package com.example.ex3_2_back.configuration;

import com.example.ex3_2_back.interceptor.AuthInterceptor;
import com.example.ex3_2_back.resolvers.CurrentUserIdResolver;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private  static final long MAX_AGE_SECS = 3600;

    AuthInterceptor authorizationInterceptor;

    CurrentUserIdResolver currentUserIdResolver;

    @Value("${interceptor}")
    boolean enabled = false;

    @Autowired
    public void setAuthorizationInterceptor(AuthInterceptor authorizationInterceptor) {
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Autowired
    public void setCurrentUserIdResolver(CurrentUserIdResolver currentUserIdResolver) {
        this.currentUserIdResolver = currentUserIdResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedHeaders("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH","DELETE")
                .exposedHeaders("Set-Cookie", "Authorization")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserIdResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/auth/**",
                        "/dev/**",
                        "/css/**",
                        "/favicon.ico",
                        "/doc.html",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/apiproject/swagger-ui.html",
                        "/doc.html",
                        "/doc.html#/**",
                        "/webjars/**"
                );
    }
}
