package com.qa.dto;

import com.qa.domain.Sector;

import java.awt.image.Kernel;
import java.util.Objects;

public class EmployeeDto {

    private Long id;
    private String name;
    private Sector sector;
    private Long certs;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, Sector sector, Long certs) {
        this.name=name;
        this.sector=sector;
        this.certs=certs;

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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Long getCerts() {
        return certs;
    }

    public void setCerts(Long certs) {
        this.certs = certs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                certs.equals(that.certs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, certs);
    }
}
