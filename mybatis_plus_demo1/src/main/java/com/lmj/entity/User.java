package com.lmj.entity;

import com.lmj.enums.SexEnum;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private SexEnum sex; // 性别
    private Integer age;
    private String email;
}
