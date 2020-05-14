package com.d7kj.dao;

import com.d7kj.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

}