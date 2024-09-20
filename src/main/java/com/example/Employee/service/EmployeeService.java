package com.example.Employee.service;

import com.example.Employee.entity.Employee;
import com.example.Employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();

    }

    public Employee addEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    public Employee getEmployeeById(Long id) {
        Employee employeeRepoById =   employeeRepo.findById(id).get();
        return employeeRepoById;
    }

    public Employee deleteEmployeeById(Long id) {

        Employee deleteEmp = this.getEmployeeById(id);

        employeeRepo.deleteById(id);
        return deleteEmp;
    }


}
