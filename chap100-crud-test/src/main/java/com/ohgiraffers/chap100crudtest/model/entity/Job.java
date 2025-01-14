package com.ohgiraffers.chap100crudtest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "job")
public class Job {

    @Id
    @Column(name = "job_code")
    private String jobCode;

    @Column(name = "job_name")
    private String jobName;
}
