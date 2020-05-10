package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long certs;

    @ManyToOne(targetEntity = Sector.class)
    private Sector sector;

    public Employee() {
    }

    public Employee(String name,Long certs) {
        this.name = name;
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

    public Long getCerts() {
        return certs;
    }

    public void setCerts(Long certs) {
        this.certs = certs;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
                name.equals(employee.name) &&
                certs.equals(employee.certs) &&
                sector.equals(employee.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, certs, sector);
    }
}

