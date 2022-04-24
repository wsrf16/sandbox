package com.sanbox.springboot.sample.shiro.controller;

import com.aio.portable.swiss.suite.log.annotation.LogMarker;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@LogMarker
public class UserController {
    @GetMapping("permissions")
    public String permissions() {
        return "permissions";
    }

    @GetMapping("updateRequirePermissions")
    @RequiresPermissions({"user:update"})
    public String updateRequirePermissions() {
        return "permissions";
    }

    @GetMapping("updateRequireRoles")
    @RequiresRoles("teacher")
    public String updateRequireRoles() {
        return "teacher";
    }
}
