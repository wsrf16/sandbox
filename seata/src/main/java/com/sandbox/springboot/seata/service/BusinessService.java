package com.sandbox.springboot.seata.service;

import com.sandbox.springboot.seata.service.BusinessService;
import com.sandbox.springboot.seata.service.OrderService;
import com.sandbox.springboot.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    /**
     * 库存http请求
     */
    @Autowired
    private StorageService storageService;

    /**
     * 订单http请求
     */
    @Autowired
    private OrderService orderService;

    /**
     * 采购
     */
    @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);

        orderService.create(userId, commodityCode, orderCount);
    }
}