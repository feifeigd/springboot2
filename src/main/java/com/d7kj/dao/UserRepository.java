package com.d7kj.dao;

import com.d7kj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String name);

}
