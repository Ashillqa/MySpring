package com.qa.dto;

import com.qa.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class SectorDto {

    private Long id;
    private String sect;
    private String description;
    private List<EmployeeDto> employees;

    public SectorDto() {
    }

    public SectorDto(String sect, List<EmployeeDto> employees) {
        this.sect = sect;
        this.employees = employees;
    }

    public SectorDto(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSect() {
        return sect;
    }

    public void setSect(String sect) {
        this.sect = sect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
