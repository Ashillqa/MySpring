package com.qa.dto;

import com.qa.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SectorDto {

    private Long id;
    private String division;
    private Set<EmployeeDto> employee;

    public SectorDto() {
    }

    public SectorDto(String division) {
        super();
        this.division = division;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Set<EmployeeDto> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<EmployeeDto> employee) {
        this.employee = employee;
    }
}
