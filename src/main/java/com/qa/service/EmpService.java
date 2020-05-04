package com.qa.service;

import com.qa.domain.Employee;
import com.qa.exception.EmployeeNotFoundException;
import com.qa.repo.empRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    private final empRepository repo;
//constructor method Autowired
    @Autowired
    public EmpService(empRepository repo) {
        this.repo = repo;
    }
//read all Employees using the findall()
    public List<Employee> readEmp(){
        return this.repo.findAll();
    }
// create an Employee using the repo.save()
    public Employee createEmp(Employee emp){
        return this.repo.save(emp);
    }
// find a repo by ID and also introduce new Exception - will help when updating and deleting
    public Employee findEmpById(Long id){
        return this.repo.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }
// Now we can check Id when updating an employee
    public Employee updateEmp(Long id, Employee emp){
        Employee update = findEmpById(id);
        update.setJobTitle(emp.getJobTitle());
        update.setContLength(emp.getContLength());
        return this.repo.save(update);
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
