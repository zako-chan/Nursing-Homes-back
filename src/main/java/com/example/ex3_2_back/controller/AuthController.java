package com.example.ex3_2_back.controller;


import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.AuthService;
import com.example.ex3_2_back.domain.auth.LoginDomain;
import com.example.ex3_2_back.domain.auth.RegisterDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AutoTakeCount
@Slf4j
@Tag(name = "权限管理",description = "AuthController")
public class AuthController {

    private AuthService authService;

    @Autowired
    @Operation(summary = "setAuthService",description = "setAuthService")
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @NotNull
    @Operation(summary = "登录",description = "登录")
    public Result login(@RequestBody @NotNull @Validated LoginDomain loginDomain, HttpServletResponse response) {
        return authService.login(loginDomain, response);
    }

    @GetMapping("/logout")
    @NotNull
    @Operation(summary = "登出",description = "登出")
    public Result logout(HttpServletResponse response) {
        authService.removeTokenCookie(response);
        return Result.success();
    }

    @PostMapping("/register")
    @Operation(summary = "注册",description = "注册")
    public Result register(@RequestBody @NotNull @Validated RegisterDomain registerDomain) {
        return authService.register(registerDomain);
    }

}
