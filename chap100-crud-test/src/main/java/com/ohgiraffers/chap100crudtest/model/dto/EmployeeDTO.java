package com.ohgiraffers.chap100crudtest.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeDTO {

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private String salary;
    private Float bonus;
    private String managerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 요청 파라미터에서 날짜 변환
    private Date hireDate;
    private Date entDate;
    private String entYn;
}
