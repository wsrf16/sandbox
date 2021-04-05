package com.sandbox.springcloud.configclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TextController {

//    @GetMapping(value = "/log")
//    public String  saveCuringEvidence(@RequestBody User user){
//        System.out.println("---------------------user:"+user.getUsername());
//        return user.getUsername();
//    }

    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

}