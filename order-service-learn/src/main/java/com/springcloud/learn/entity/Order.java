package com.springcloud.learn.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "order", schema = "blog")
@Data
@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long GoodId;

    private Long version;

}
