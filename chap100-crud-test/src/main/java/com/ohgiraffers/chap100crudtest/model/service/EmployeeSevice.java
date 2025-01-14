package com.ohgiraffers.chap100crudtest.model.service;

import com.ohgiraffers.chap100crudtest.model.dao.DeptRepository;
import com.ohgiraffers.chap100crudtest.model.dao.EmployeeRepository;
import com.ohgiraffers.chap100crudtest.model.dao.JobRepository;
import com.ohgiraffers.chap100crudtest.model.dto.DeptDTO;
import com.ohgiraffers.chap100crudtest.model.dto.EmployeeDTO;
import com.ohgiraffers.chap100crudtest.model.dto.JobDTO;
import com.ohgiraffers.chap100crudtest.model.entity.Dept;
import com.ohgiraffers.chap100crudtest.model.entity.Employee;
import com.ohgiraffers.chap100crudtest.model.entity.Job;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EmployeeSevice {

    private final EmployeeRepository repository;
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;
    private final DeptRepository deptRepository;

    public EmployeeSevice(EmployeeRepository repository, ModelMapper modelMapper, JobRepository jobRepository, DeptRepository deptRepository) {

        this.repository = repository;
        this.modelMapper = modelMapper;
        this.jobRepository = jobRepository;
        this.deptRepository = deptRepository;
    }

    public List<EmployeeDTO> employeeFindAll() {

        List<Employee> employeeDTO = repository.findAll(Sort.by("empId").descending());

        return employeeDTO.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public EmployeeDTO employeeFindByEmpId(String empId) {

        Employee employeeEmpId = repository.findById(empId).orElseThrow(IllegalArgumentException::new);

        System.out.println("서비스 쪽 직원 상세페이지 테스트 = " + employeeEmpId);

        return modelMapper.map(employeeEmpId, EmployeeDTO.class);
    }

    public void employeeRegist(EmployeeDTO employee) {

        repository.save(modelMapper.map(employee, Employee.class));

    }

    public List<JobDTO> employeeJob() {

        List<Job> jobList = jobRepository.findAll();

        return jobList.stream().map(job -> modelMapper.map(job, JobDTO.class)).collect(Collectors.toList());
    }

    public List<DeptDTO> employeeDept() {

        List<Dept> dept = deptRepository.findAll();

        return dept.stream().map(depts -> modelMapper.map(depts, DeptDTO.class)).collect(Collectors.toList());
    }
}
