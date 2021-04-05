package com.sanbox.shiro.sample.shiroshiro.controller;

import com.aio.portable.swiss.suite.log.annotation.LogMarker;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@LogMarker
public class AccountController {
    @GetMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token1 = new UsernamePasswordToken(username, password);
        BearerToken token = new BearerToken(token1.getUsername(), token1.getUsername());
        subject.login(token);
        return "ok";
    }
//    @PostMapping("login")
//    public String login(@RequestBody Map<String, String> params) {
//        if (params.containsKey("username") && params.containsKey("password")) {
//            String username = params.get("username");
//            String password = params.get("password");
//
//            Subject subject = SecurityUtils.getSubject();
//            // 在认证提交前准备 token（令牌）
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//            subject.login(token);
//            return "ok";
//        } else {
//            return "{\"message\":\"缺少重要参数或参数无效\"}";
//        }
//    }


    @GetMapping("ok")
    public String ok() {
        return "ok";
    }
}
