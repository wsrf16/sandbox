package com.sandbox.springboot.seata.service;

import com.aio.portable.swiss.suite.storage.rds.jpa.JPASugar;
import com.sandbox.springboot.seata.model.Account;
import com.sandbox.springboot.seata.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account debit(String userId, int money) {
        final Account account = new Account();
        account.setUserId(userId);

        final Specification<Account> specification = JPASugar.<Account>buildSpecification(account);
        final Account target = accountRepository.findOne(specification).get();
        if (target.getMoney() - money < 0)
            throw new RuntimeException("money is not enough!!!!!!!!!");

        target.setMoney(target.getMoney() - money);
        return accountRepository.save(target);
    }
}