package com.springcloud.learn.controller;

import com.springcloud.learn.entity.Account;
import com.springcloud.learn.repository.AccountRepository;
import com.springcloud.learn.repository.UserRepository;
import com.springcloud.learn.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@Slf4j
public class UserController {

//    @Value("${eureka.instance.instance-id}")
//    private String port;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("debit")
    public String debit(Long accountId, BigDecimal money) {
        Account account = accountRepository.getOne(accountId);
        BigDecimal balance = account.getBalance().subtract(money).setScale(2, RoundingMode.HALF_UP);
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("余额不足");
        }
        account.setBalance(balance);
        account.setVersion(account.getVersion() + 1);
        accountRepository.save(account);
        return "扣款成功";
    }
}
