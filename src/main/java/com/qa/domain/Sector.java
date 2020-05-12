package com.qa.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Sector {
    @Id
    @GeneratedValue
    private Long id;

    private String division;

    @OneToMany(mappedBy ="sector", fetch = FetchType.LAZY)
    private List<Employee> employee = new ArrayList<>();


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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

}
