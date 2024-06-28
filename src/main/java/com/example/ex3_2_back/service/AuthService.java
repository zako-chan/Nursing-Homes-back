package com.example.ex3_2_back.service;

import com.example.ex3_2_back.domain.DevMessage;
import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.repository.UserRepository;
import com.example.ex3_2_back.utils.MyJwtUtil;
import com.example.ex3_2_back.domain.auth.LoginDomain;
import com.example.ex3_2_back.domain.auth.RegisterDomain;
import com.example.ex3_2_back.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @apiNote 用于用户权限的识别
 */
@Service
@Slf4j
public class AuthService {
    private UserRepository userRepository;

    private MyJwtUtil jwtUtil;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setJwtUtil(MyJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @NotNull
    public Result login(@NotNull LoginDomain loginDomain, @NotNull HttpServletResponse response) {
        // 查找用户是否存在
        Optional<User> optionalUser = userRepository.findByNameAndPassword(loginDomain.getUsername(), loginDomain.getPassword());

        if (optionalUser.isEmpty()) {
            String message = String.format("wrong username %s or password %s", loginDomain.getUsername(), loginDomain.getPassword());
            log.info(message);
            return Result.error(message).addErrors(message).addDevMessages(new DevMessage(loginDomain));
        }

        User user = optionalUser.get();
        log.info(String.format("login username %s with user ID %d", user.getName(), user.getId()));
        Long userId = user.getId();
        // 生成 Token
        setTokenCookie(userId, response);

        return Result.success();
    }

    @NotNull
    public Result register(@NotNull RegisterDomain registerDomain) {

        if (userRepository.existsByName(registerDomain.getUsername())) {
            String message = String.format("username %s already exists", registerDomain.getUsername());
            log.info(message);
            return Result.error(message).addErrors(registerDomain.getUsername());
        }

        if (!Objects.equals(registerDomain.getPassword1(), registerDomain.getPassword2())) {
            String message = "inconsistent two passwords";
            log.info(message);
            return Result.error(message);
        }

        userRepository.save(User.builder()
                .name(registerDomain.getUsername())
                .password(registerDomain.getPassword1())
                .email(registerDomain.getEmail())
                .build());

        return Result.success();
    }

    /**
     * 设置token
     *
     * @param userId 用户id
     * @param response 当次的响应
     */
    private void setTokenCookie(Long userId, HttpServletResponse response) {
        String newToken = jwtUtil.createToken(userId); // 生成新的 Token
        Cookie cookie = new Cookie("token", newToken);
        cookie.setHttpOnly(false);
        cookie.setSecure(true); // 仅在 HTTPS 连接中传输
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 1 周
        log.info("cookie: " + cookie.getValue());
        response.addCookie(cookie);
    }

    /**
     * 清除token
     *
     * @param response 当次的响应
     */
    public void removeTokenCookie(@NotNull HttpServletResponse response) {
        var cookie = new Cookie("token", "");
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }

    /**
     * 检查token的有效性并更新token
     *
     * @param request  当次的请求
     * @param response 当次的响应
     * @return 结果
     */
    @NotNull
    public Result validateAndUpdateToken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        var cookies = request.getCookies();
        //log.info(request.toString());
        if (cookies == null || cookies.length == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s - %s: No token in cookie", request.getRequestURL(),request.getMethod());
            log.info(message);
            return Result.error(message);
        }

        Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny();
        String token = optionalCookie.map(Cookie::getValue).orElse("");

        log.info(String.format("old token: %s", token));

        // 获取的是用户 ID
        var optionalUserId = jwtUtil.decodeToken(token);

        if (optionalUserId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: Invalid or expired token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        var userId = optionalUserId.get();
        request.setAttribute("userId", userId); // 将用户 ID 设置为请求属性

        // 使用用户 ID 生成新的 Token
        setTokenCookie(userId, response);

        return Result.success();
    }
}
