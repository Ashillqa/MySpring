package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sect;
    private String description;

    @OneToMany(mappedBy = "sector", fetch = FetchType.LAZY)
    private List<Employee> employee = new ArrayList<>();

    public List<Employee> getEmployee() {
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sector sector = (Sector) o;
        return id.equals(sector.id) &&
                sect.equals(sector.sect) &&
                description.equals(sector.description) &&
                employee.equals(sector.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sect, description, employee);
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }
}
