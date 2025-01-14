package com.ohgiraffers.chap100crudtest.controller;

import com.ohgiraffers.chap100crudtest.model.dto.DeptDTO;
import com.ohgiraffers.chap100crudtest.model.dto.EmployeeDTO;
import com.ohgiraffers.chap100crudtest.model.dto.JobDTO;
import com.ohgiraffers.chap100crudtest.model.entity.Dept;
import com.ohgiraffers.chap100crudtest.model.service.EmployeeSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeSevice employeeSevice;

    public EmployeeController(EmployeeSevice employeeSevice) {

        this.employeeSevice = employeeSevice;
    }

    @GetMapping("/")
    public String main(){

        return "main/main";
    }

    @GetMapping("employee/findAll")
    public String employeeFindAll(Model model) {

        List<EmployeeDTO> employeeFindAll = employeeSevice.employeeFindAll();

        System.out.println("employeeFindAll = " + employeeFindAll);

        model.addAttribute("employeeFindAll", employeeFindAll);

        return "employee/findAll";
    }

    @GetMapping("employee/findByEmpId/{empId}")
    public String employeeFindByEmpId(Model model, @PathVariable String empId) {

        EmployeeDTO employeeEmpId = employeeSevice.employeeFindByEmpId(empId);

        System.out.println("메뉴 상세조회 컨트롤러 테스트 = " + employeeEmpId);

        model.addAttribute("employeeEmpId", employeeEmpId);

        return "/employee/findByEmpId";
    }

    @GetMapping("employee/regist")
    public String registEmployee() {

        return "/employee/registEmployee";
    }

    @PostMapping("employee/regist")
    public String employeeRegist(@ModelAttribute EmployeeDTO employee) {

        employeeSevice.employeeRegist(employee);

        return "redirect:employee/findAll";
    }

    @GetMapping(value = "employee/job")
    @ResponseBody
    public List<JobDTO> employeeJob() {

        List<JobDTO> job = employeeSevice.employeeJob();

        System.out.println("직급 데이터 보내기 = " + job);

        return job;
    }

    @GetMapping(value = "employee/dept")
    @ResponseBody
    public List<DeptDTO> employeeDept() {

        List<DeptDTO> dept = employeeSevice.employeeDept();

        System.out.println("부서 데이터 보내기 = " + dept);

        return dept;

    }

}
