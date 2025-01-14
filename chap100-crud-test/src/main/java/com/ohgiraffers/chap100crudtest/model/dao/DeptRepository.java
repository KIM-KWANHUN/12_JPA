package com.ohgiraffers.chap100crudtest.model.dao;

import com.ohgiraffers.chap100crudtest.model.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept, String> {
}
