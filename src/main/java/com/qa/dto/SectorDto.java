package com.qa.dto;

import com.qa.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SectorDto {

    private Long id;
    private String division;
    private List<EmployeeDto> employee = new ArrayList<>();

    public SectorDto() {
    }

    public SectorDto(String division) {
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

    public List<EmployeeDto> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeDto> employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employee == null) ? 0 : employee.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((division == null) ? 0 : division.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SectorDto other = (SectorDto) obj;
        if (employee == null) {
            if (other.employee != null)
                return false;
        } else if (!employee.equals(other.employee))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (division == null) {
            if (other.division != null)
                return false;
        } else if (!division.equals(other.division))
            return false;
        return true;
    }
}
