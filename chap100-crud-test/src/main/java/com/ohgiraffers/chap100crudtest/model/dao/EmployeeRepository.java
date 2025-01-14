package com.ohgiraffers.chap100crudtest.model.dao;

import com.ohgiraffers.chap100crudtest.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
