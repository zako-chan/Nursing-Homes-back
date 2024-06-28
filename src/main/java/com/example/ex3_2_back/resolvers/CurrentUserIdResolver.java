package com.example.ex3_2_back.resolvers;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.utils.MyJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
@Slf4j
@Component
public class CurrentUserIdResolver implements HandlerMethodArgumentResolver {

    private final MyJwtUtil jwtUtil;

    @Autowired
    public CurrentUserIdResolver(MyJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 确保该解析器只应用于带有 @CurrentUserId 注解且类型为 Long 的参数
        return parameter.hasParameterAnnotation(CurrentUserId.class) && parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("HttpServletRequest: " + request);

        if (request != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                Optional<Cookie> optionalCookie = Arrays.stream(cookies)
                        .filter(cookie -> cookie.getName().equals("token"))
                        .findAny();
                String token = optionalCookie.map(Cookie::getValue).orElse("");

                // Decode the token to get the user ID
                var optionalUserId = jwtUtil.decodeToken(token);
                if(optionalUserId.isEmpty()){
                    return null;
                }
                var userId = optionalUserId.get();
                log.info("aaaaa"+userId);
                if (optionalUserId.isPresent()) {
                    return optionalUserId.get();
                }
            }
        }
        // 如果没有找到用户 ID，返回 null 或者抛出异常
        return null; // 或者 throw new IllegalArgumentException("No user ID found in token");
    }
}
