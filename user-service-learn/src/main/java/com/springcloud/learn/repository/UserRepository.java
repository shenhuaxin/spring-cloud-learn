package com.springcloud.learn.repository;

import com.springcloud.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
