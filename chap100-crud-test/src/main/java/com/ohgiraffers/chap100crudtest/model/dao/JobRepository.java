package com.ohgiraffers.chap100crudtest.model.dao;

import com.ohgiraffers.chap100crudtest.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
