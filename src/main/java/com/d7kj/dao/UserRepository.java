package com.d7kj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.d7kj.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    public User findByName(String name);

}
