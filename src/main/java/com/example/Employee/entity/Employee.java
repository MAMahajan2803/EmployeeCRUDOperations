package com.example.Employee.entity;

import jakarta.persistence.*;
;

@Entity
@Table(name = "employee")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        private String department;
        private int salary;

        public Employee(Long id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

    public Employee() {
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }
}

