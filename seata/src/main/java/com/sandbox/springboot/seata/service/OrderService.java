package com.sandbox.springboot.seata.service;

import com.sandbox.springboot.seata.model.Account;
import com.sandbox.springboot.seata.model.Order;
import com.sandbox.springboot.seata.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountService accountService;

    public Account create(String userId, String commodityCode, int count) {
        int money = calculate(commodityCode, count);

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(money);
        orderRepository.save(order);

        return accountService.debit(userId, money);
    }

    private int calculate(String commodityCode, int count) {
        int unitPrice;
        switch (commodityCode) {
            default:
                unitPrice = 100;
        }
        return unitPrice * count;
    }
}