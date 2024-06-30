package com.example.ex3_2_back.controller;

import com.example.ex3_2_back.annotations.CurrentUserId;
import com.example.ex3_2_back.domain.TResult;
import com.example.ex3_2_back.domain.user.UserCreateDomain;
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
    @Operation(summary = "查询所有义工", description = "查询所有义工")
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
    @Operation(summary = "根据id查询义工", description = "根据id查询义工")
    public TResult<User> getUserById(@Schema(description = "义工id") @RequestParam Integer id) {
        User user = userService.getUserById(id).orElse(null);
        return TResult.success(user);

    }

    @GetMapping("/name")
    @Operation(summary = "根据username查询义工", description = "根据username查询义工")
    public TResult<User> getUserByName(@Schema(description = "username") @RequestParam String name) {
        User user = userService.findUserByName(name);
        return TResult.success(user);
    }

    @PostMapping
    @Operation(summary = "添加义工", description = "添加义工")
    public TResult<Integer> addUser(@Schema(hidden = true) @CurrentUserId Integer userId,
                                         @RequestBody UserCreateDomain userCreateDomain) {
        User user = new User(userCreateDomain);
        Integer id = userService.addUser(user);
        user.setUpdateBy(userId);
        userService.updateUser(user);
        return TResult.success(id);
    }

    @PutMapping
    @Operation(summary = "修改义工信息", description = "修改义工信息")
    public TResult updateUser(@Schema(hidden = true) @CurrentUserId Integer userId,
                                   @RequestBody User user) {
        user.setUpdateBy(userId);
        userService.updateUser(user);
        return TResult.success();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除义工", description = "删除义工")
    public TResult deleteUser(@Schema(description = "义工id") @RequestParam Integer id) {
        userService.deleteUser(id);
        return TResult.success();
    }

}
