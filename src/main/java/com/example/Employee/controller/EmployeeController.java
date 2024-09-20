package com.example.Employee.controller;

import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/empController")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/all")
    public List<Employee> getAllEmployee()
    {
        System.out.println("Getting all Employees");

        return employeeService.getAllEmployee();

    }

//    @RequestMapping("/save")
//    public String addEmployee()
//    {
//        Employee emp = new Employee(10L,"Emp10","dep10",500);
//        System.out.println("putting Employee");
//        Employee saved = employeeService.addEmployee(emp);
//        return saved.getName();
//
//    }

    @RequestMapping("/empByDepartment")
    public List<String> getEmpByDepartmemnt() {
        List<Employee> employeeList = employeeService.getAllEmployee();

        List<String> empName = employeeList.stream().filter(e->e.getDepartment().equals("Hardware")).map(e->e.getName()).toList();
        return empName;
    }

    @RequestMapping("/empDetailsBySalary")
    public List<Employee> getEmpDetailsBySalary() {
        List<Employee> employeeList = employeeService.getAllEmployee();

        List<Employee> empDetails = employeeList.stream().filter(e->e.getSalary()>500).toList();
        return empDetails;
    }

    @RequestMapping("/noOfEmpByDept")
    public Map<String, Long> getNoOfEmpByDept() {
        List<Employee> employeeList = employeeService.getAllEmployee();

        Map<String, Long> empDetails = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        return empDetails;
    }

    @RequestMapping("/empWithMaxSalary")
    public Employee getEmpWithMaxSalary() {
        List<Employee> employeeList = employeeService.getAllEmployee();

        Employee emp = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();

        return emp;
    }

}

