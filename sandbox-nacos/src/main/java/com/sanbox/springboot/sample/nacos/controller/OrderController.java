package com.sanbox.springboot.sample.nacos.controller;

import com.aio.portable.swiss.suite.log.annotation.LogMarker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@LogMarker
public class OrderController {
    @GetMapping("one")
    public String one() {
        return "order-one";
    }

}
