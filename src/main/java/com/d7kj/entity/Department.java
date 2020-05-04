package com.d7kj.entity;

import com.d7kj.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @OneToMany(mappedBy = "department") // User的属性department
    Set<User> users = new HashSet<>();

    public Department(){

    }
}
