package com.ohgiraffers.chap100crudtest.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_no")
    private String empNo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "job_code")
    private String jobCode;

    @Column(name = "sal_level")
    private String salLevel;

    @Column(name = "salary")
    private String salary;

    @Column(name = "bonus")
    private Float bonus;

    @Column(name = "manager_id")
    private String managerId;

    @Column(name = "hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 요청 파라미터에서 날짜 변환
    private Date hireDate;

    @Column(name = "ent_date")
    private Date entDate;

    @Column(name = "ent_yn")
    private String entYn;
}
