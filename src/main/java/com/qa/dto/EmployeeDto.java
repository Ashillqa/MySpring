package com.qa.dto;

import java.awt.image.Kernel;
import java.util.Objects;

public class EmployeeDto {

    private Long id;
    private String name;
    private String jobTitle;
    private Long contLength;

    public EmployeeDto() {
    }

    public EmployeeDto(String name,String jobTitle, Long contLength) {
        this.name=name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                jobTitle.equals(that.jobTitle) &&
                contLength.equals(that.contLength);
    }
}
