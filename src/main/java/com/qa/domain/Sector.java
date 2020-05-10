package com.qa.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String division;

    @OneToMany(mappedBy ="sector", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employee;


  public Sector (){
  }
  public Sector(String division){
      this.division=division;
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

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

}
