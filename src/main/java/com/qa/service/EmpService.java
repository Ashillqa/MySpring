package com.qa.service;

import com.qa.domain.Employee;
import com.qa.domain.Sector;
import com.qa.dto.EmployeeDto;
import com.qa.exception.EmployeeNotFoundException;
import com.qa.repo.empRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpService {

    private final empRepository repo;
 // private modelMapper
    private final ModelMapper mapper;
//constructor method Autowired
    @Autowired
    public EmpService(empRepository repo,ModelMapper mapper) {
        this.repo = repo;
        this.mapper=mapper;
    }
 // making a map to Dto for employee to convert types to be passed to controller
    private EmployeeDto mapToDto(Employee employee){
        return this.mapper.map(employee, EmployeeDto.class);
    }

//read all Employees using the findall() but change types to DTO and use the mapToDto using stream <- important
    public List<EmployeeDto> readEmp(){
        return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }
// create an Employee using the repo.save() again change to type DTO
    public EmployeeDto createEmp(Employee emp){
        Employee tempEmp = this.repo.save(emp);
        return this.mapToDto(tempEmp);
    }
// find a repo by ID and also introduce new Exception - will help when updating and deleting again maptoDto
    public EmployeeDto findEmpById(Long id){
        return this.mapToDto(this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new));
    }
// Now we can check Id when updating an employee
    public EmployeeDto updateEmp(Long id, Employee emp){
        Employee update = this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new);
        update.setCerts(emp.getCerts());
        Employee tempEmp = this.repo.save(emp);
        return this.mapToDto(tempEmp);
    }
 // Delete an employee again by first checking the ID actually exists
    public boolean deleteEmp(Long id){
        if(!this.repo.existsById(id)){
            throw new EmployeeNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }



}
