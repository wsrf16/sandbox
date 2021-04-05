package com.sandbox.springboot.seata.repository;


import com.sandbox.springboot.seata.model.Order;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface OrderRepository extends JpaRepositoryImplementation<Order, Integer> {
}
