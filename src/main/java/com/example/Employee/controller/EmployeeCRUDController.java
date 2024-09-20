package com.example.Employee.controller;

import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//RestController is combination of controller and responseBody
@RestController
@RequestMapping("/employee")
public class EmployeeCRUDController {

    @Autowired
    EmployeeService employeeService;

    //ResponseEntity will use to print output
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        System.out.println("Getting all Employees");
        List<Employee> list =  employeeService.getAllEmployee();

        //return employeeService.getAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

 //   @PostMapping("/save")
//    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp )     //RequestBody use to take input from postman
//    {
//        System.out.println("putting Employee");
//        Employee saved = employeeService.addEmployee(emp);
//        return new ResponseEntity<>(saved, HttpStatus.CREATED);
//
//    }
//

//    @GetMapping("/save")
//    public Employee addEmployee()                                     //RespondeEntity use to print output to postman
//    {
//        System.out.println("putting Employees");
//        Employee emp = new Employee(7L,"Emp7","dep7",700);
//        return employeeService.addEmployee(emp);
//
//
//    }

    @GetMapping("/getEmp/{empID}")
    public Employee getEmployeeByid( @PathVariable("empID") Long empIDLocal) {
        System.out.println("finding Employee ");
        Employee employee =  employeeService.getEmployeeById(empIDLocal);
        System.out.println("Found Employee " + employee.toString());
        return employee;

    }

    @DeleteMapping("/deleteEmp/{empID}")
    public Employee deleteEmployeeById( @PathVariable("empID") Long empIDLocal) {
        System.out.println("finding Employee with ID : " + empIDLocal+ " for deleting it");
        Employee employee =  employeeService.deleteEmployeeById(empIDLocal);
        System.out.println("deleting Employee : "+ employee.toString());
        return employee;

    }


}
