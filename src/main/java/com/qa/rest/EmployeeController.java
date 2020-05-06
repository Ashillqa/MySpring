package com.qa.rest;

import com.qa.domain.Employee;
import com.qa.dto.EmployeeDto;
import com.qa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<EmployeeDto>> getAllEmps(){
        return ResponseEntity.ok(this.service.readEmp());
    }

    // creating is a POST method so post mapping and you take in a emp so requestBody
    @PostMapping("/createEmp")
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody Employee emp){
        return new ResponseEntity<EmployeeDto>(this.service.createEmp(emp), HttpStatus.CREATED);
    }
 // need to do find by ID and this will take a pathVariable rather than body
    @GetMapping("/empById/{id}")
    public ResponseEntity<EmployeeDto> empById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findEmpById(id));
    }
 // update is to PUT so put mapping and again requestBody but two parameters
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<EmployeeDto> updateEmp(@PathVariable Long id, @RequestBody Employee emp){
        return ResponseEntity.ok(this.service.updateEmp(id, emp));
    }
 // Deleting employee again takes a path variable of Long Id
    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable Long id){
        return this.service.deleteEmp(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @PutMapping("/updateEmp2")
    public ResponseEntity<EmployeeDto> updateNote2(@PathParam("id") Long id, @RequestBody Employee emp){
        return ResponseEntity.ok(this.service.updateEmp(id, emp));
    }
}
