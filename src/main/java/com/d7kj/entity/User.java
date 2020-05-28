package com.d7kj.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

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