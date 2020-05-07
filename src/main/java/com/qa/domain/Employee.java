package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String jobTitle;
    private Long contLength;

    @ManyToOne(targetEntity = Sector.class)
    private Sector sector;

    public Employee() {
    }

    public Employee(String name, String jobTitle, Long contLength) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.contLength = contLength;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getContLength() {
        return contLength;
    }

    public void setContLength(Long contLength) {
        this.contLength = contLength;
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
                jobTitle.equals(employee.jobTitle) &&
                contLength.equals(employee.contLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, contLength);
    }
}

