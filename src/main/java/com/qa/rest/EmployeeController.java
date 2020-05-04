package com.qa.rest;

import com.qa.domain.Employee;
import com.qa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmpService service;
//Autowired constructor
    @Autowired
    public EmployeeController(EmpService service) {
        this.service = service;
    }
// mapping for reading all employees this is the bit you put after localhost...
    @GetMapping("/getAllEmps")
    public List<Employee> getAllEmps(){
        return this.service.readEmp();
    }
 // creating is a POST method so post mapping and you take in a emp so requestBody
    @PostMapping("/createEmp")
    public Employee createEmp(@RequestBody Employee emp){
        return this.service.createEmp(emp);
    }
 // need to do find by ID and this will take a pathVariable rather than body
    @GetMapping("/empById/{id}")
    public Employee empById(@PathVariable Long id){
        return this.service.findEmpById(id);
    }
 // update is to PUT so put mapping and again requestBody but two parameters
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmp(@PathVariable Long id, @RequestBody Employee emp){
        return this.service.updateEmp(id,emp);
    }
 // Deleting employee again takes a path variable of Long Id
    @DeleteMapping("/deleteEmp/{id}")
    public boolean deleteEmp(@PathVariable Long id){
        return this.service.deleteEmp(id);
    }
}
