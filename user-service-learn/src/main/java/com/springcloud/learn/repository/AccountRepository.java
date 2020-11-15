package com.springcloud.learn.repository;

import com.springcloud.learn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
