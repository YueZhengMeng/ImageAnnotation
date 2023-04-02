package com.shou.imageannotation.controller;

import com.shou.imageannotation.po.User;
import com.shou.imageannotation.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Secured("ROLE_admin")
    @ApiOperation(value = "查看所有User信息", notes = "管理员权限")
    List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "用户注册", notes = "所有权限\n只需要username与password")
    int registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "获取当前登录的User的所有信息", notes = "主要用于获取role信息\n用户权限")
    User getLoginUser() {
        return userService.getLoginUser();
    }

    @GetMapping("/byUserID/{userID}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "获取某个User的所有信息", notes = "用户权限")
    User getUserByID(@PathVariable int userID) {
        return userService.getUserByID(userID);
    }

    @GetMapping("/byUserName/{userName}")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "获取某个User的所有信息", notes = "用户权限")
    User getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    @PutMapping("/resetUserName")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "重置用户名", notes = "用户权限\n只需要userID与username")
    int resetUsername(@RequestBody User user) {
        return userService.resetUsername(user);
    }

    @PutMapping("/resetPassword")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_admin", "ROLE_checker", "ROLE_annotater", "ROLE_user"})
    @ApiOperation(value = "重置密码", notes = "用户权限\n只需要userID与password")
    int resetPassword(@RequestBody User user) {
        return userService.resetPassword(user);
    }

    @PutMapping("/resetRole")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured("ROLE_admin")
    @ApiOperation(value = "分配角色", notes = "管理员权限\n只需要userID与role")
    int resetRole(@RequestBody User user) {
        return userService.resetRole(user);
    }

    @PutMapping("/banUser/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured("ROLE_admin")
    @ApiOperation(value = "封禁用户", notes = "管理员权限")
    int banUser(@PathVariable int userID) {
        return userService.banUser(userID);
    }

    @PutMapping("/unbanUser/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured("ROLE_admin")
    @ApiOperation(value = "解封用户", notes = "管理员权限")
    int unbanUser(@PathVariable int userID) {
        return userService.unbanUser(userID);
    }

    @DeleteMapping("/deleteUser/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured("ROLE_admin")
    @ApiOperation(value = "删除用户", notes = "管理员权限")
    int deleteUser(@PathVariable int userID) {
        return userService.deleteUser(userID);
    }
}
