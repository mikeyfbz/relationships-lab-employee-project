package com.codeclan.example.relationships.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numOfDays;



    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "employees_projects", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "project_id", nullable = false, updatable = false)
    })
    private List<Employee> employees;


    public Project() {
    }

    public Project(int numOfDays) {
        this.numOfDays = numOfDays;
        this.employees = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployeeToList(Employee employee){
        this.employees.add(employee);
    }
}
