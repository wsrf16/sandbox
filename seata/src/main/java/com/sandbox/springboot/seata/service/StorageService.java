package com.sandbox.springboot.seata.service;

import com.aio.portable.swiss.suite.bean.BeanSugar;
import com.aio.portable.swiss.suite.storage.db.jpa.JPASugar;
import com.sandbox.springboot.seata.model.Order;
import com.sandbox.springboot.seata.model.Storage;
import com.sandbox.springboot.seata.repository.OrderRepository;
import com.sandbox.springboot.seata.repository.StorageRepository;
import com.sandbox.springboot.seata.service.AccountService;
import com.sandbox.springboot.seata.service.OrderService;
import com.sandbox.springboot.seata.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;

    public void deduct(String commodityCode, int count) {

        final Storage storage = new Storage();
        storage.setCommodityCode(commodityCode);
//        storage.setCount(count);
        final Specification<Storage> specification = JPASugar.<Storage>buildSpecification(storage);

        final Storage target = storageRepository.findOne(specification).get();
        if (target.getCount() - count < 0)
            throw new RuntimeException("left storage is not enough!!!!!!!!!");

        target.setCount(target.getCount() - count);
        storageRepository.save(target);
//        JPASugar.saveIgnoreNullProperties(storageRepository, storage);

    }

}