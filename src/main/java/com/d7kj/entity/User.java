package com.d7kj.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //
    @Column
    String name;

    @Column(name = "create_time")
    Date createTime;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    public User(){
        // JPA 要求实体必须有一个空的构造函数
    }
}