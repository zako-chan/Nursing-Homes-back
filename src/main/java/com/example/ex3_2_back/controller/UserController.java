package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.user.UserSearchDomain;
import com.example.ex3_2_back.domain.user.UserCreateDomain;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.log.AutoTakeCount;
import com.example.ex3_2_back.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    public TResult<Page<User>> allUsers(@Schema(defaultValue = "0") @RequestParam int page,
                                                  @Schema(defaultValue = "10") @RequestParam int pageSize,
                                                  @RequestParam(required = false) String username){
        if (username != null) {
            Page<User> users = userService.getUserByUsername(username, PageRequest.of(page, pageSize));
            return TResult.success(users);
        }else {
            Page<User> users = userService.getAllUser(PageRequest.of(page, pageSize));
            return TResult.success(users);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询用户", description = "根据id查询用户")
    public TResult<User> getUserById(@Schema(description = "用户id") @PathVariable Integer id) {
        User user = userService.getUserById(id).orElse(null);
        return TResult.success(user);

    }

    @GetMapping("/name")
    @Operation(summary = "根据username查询用户", description = "根据username查询用户")
    public TResult<Optional<User>> getUserByName(@Schema(description = "username") @RequestParam String name) {
        Optional<User> user = userService.findUserByName(name);
        return TResult.success(user);
    }

    @PostMapping
    @Operation(summary = "添加用户", description = "添加用户")
    public TResult<Integer> addUser(@Schema(hidden = true) @CurrentUserId Integer userId,
                                         @RequestBody UserCreateDomain userCreateDomain) {
        User user = new User(userCreateDomain);
        Integer id = userService.addUser(user);
        return TResult.success(id);
    }

    @PutMapping
    @Operation(summary = "修改用户信息", description = "修改用户信息")
    public TResult updateUser(@Schema(hidden = true) @CurrentUserId Integer userId,
                                   @RequestBody User user) {
        userService.updateUser(user);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "删除用户")
    public TResult deleteUser(@Schema(description = "用户id") @PathVariable Integer id) {
        userService.deleteUser(id);
        return TResult.success();
    }

    @PostMapping("/search")
    @Operation(summary = "查找用户", description = "动态查找用户")
    public TResult<Page<User>> searchUser(@RequestBody UserSearchDomain userSearchDomain,
                                                @RequestParam int page,
                                                @RequestParam int pageSize) {
        return TResult.success(userService.searchUserDynamic(userSearchDomain,PageRequest.of(page,pageSize)));
    }
}
