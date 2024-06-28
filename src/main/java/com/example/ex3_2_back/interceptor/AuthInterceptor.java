package com.example.ex3_2_back.interceptor;


import com.example.ex3_2_back.service.AuthService;
import com.example.ex3_2_back.utils.LoginNotRequire;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        log.info("preHandle"+ request.getRequestURI() + "---" + request.getMethod());
        if(request.getMethod().equals("OPTIONS") || (handler instanceof HandlerMethod && ((HandlerMethod)handler).getMethodAnnotation(LoginNotRequire.class) != null)){
            return true;
        }
        return authService.validateAndUpdateToken(request, response).isSuccess();
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {

    }

}


