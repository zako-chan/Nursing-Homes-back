package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.Result;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.UserService;
import com.example.ex3_2_back.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@AutoTakeCount
@Tag(name = "用户管理",description = "AuthController")
public class UserController {
    private UserService userService;

    @Autowired
    @Operation(summary = "setUserRepository", description = "setUserRepository")
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "查询所有用户", description = "查询所有用户")
    public Result allUser() {
        try {
            List<User> users = userService.findAllUsers();
            return Result.success(users);
        } catch (RuntimeException e) {
            return Result.error("查询用户失败，报错为: " + e.getMessage());
        }
    }

//    @GetMapping("/{name}")
//    @Operation(summary = "查询单个用户", description = "查询单个用户")
//    public Result getOneUser(@PathVariable String name) {
//        try {
//            User user = userService.findUserByName(name);
//            return Result.success(user);
//        } catch (RuntimeException e) {
//            return Result.error("查询用户失败，报错为: " + e.getMessage());
//        }
//    }

    @PostMapping
    @Operation(summary = "创建用户", description = "创建用户")
    public Result createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return Result.success("创建用户成功");
        } catch (RuntimeException e) {
            return Result.error("创建用户失败，报错为: " + e.getMessage());
        }
    }

//    @GetMapping("/userinfo")
//    public String getUserInfo(@CurrentUserId String userId) {
//        // 使用注入的用户 ID
//        return "User ID: " + userId;
//    }

    @DeleteMapping("/{name}")
    @Operation(summary = "删除用户",description = "删除用户")
    public Result delete(@PathVariable String name) {
        try {
            userService.deleteUserByName(name);
            return Result.success("删除用户成功");
        } catch (RuntimeException e) {
            return Result.error("删除用户失败，报错为: " + e.getMessage());
        }
    }

    @GetMapping("/myInfo")
    @Operation(summary = "查询当前用户信息", description = "查询当前用户信息")
    public Result thisUser(@Parameter(hidden = true) @CurrentUserId Long uid) {
        try {
            User user = userService.findUserById(uid);
            return Result.success(user);
        } catch (RuntimeException e) {
            return Result.error("查询用户失败，报错为: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "查询当前作者信息", description = "查询当前作者信息")
    public Result getAuthorById(@PathVariable Long id) {
        try {
            User user = userService.findUserById(id);
            return Result.success(user);
        } catch (RuntimeException e) {
            return Result.error("查询用户失败，报错为: " + e.getMessage());
        }
    }


}
