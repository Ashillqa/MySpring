package com.qa.rest;

import com.qa.domain.Employee;
import com.qa.domain.Sector;
import com.qa.dto.SectorDto;
import com.qa.service.EmpService;
import com.qa.service.SectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SectorController {
    private final SectService service;
//Autowired constructor
    @Autowired
    public SectorController(SectService service) {
        this.service = service;
    }
// mapping for reading all employees this is the bit you put after localhost...
    @GetMapping("/getAllSectors")
    public ResponseEntity<List<SectorDto>> getAllSectors(){
        return ResponseEntity.ok(this.service.readSect());
    }
 // creating is a POST method so post mapping and you take in a emp so requestBody but Dto version
    @PostMapping("/createSect")
    public ResponseEntity<SectorDto> createSect(@RequestBody Sector sector){
        return new ResponseEntity<SectorDto>(this.service.createSect(sector), HttpStatus.CREATED);
    }
 // need to do find by ID and this will take a pathVariable rather than body having response entity because of Dto
    @GetMapping("/sectById/{id}")
    public ResponseEntity<SectorDto> sectById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findSectById(id));
    }
 // update is to PUT so put mapping and again requestBody but two parameters again response entity
    @PutMapping("/updateSect/{id}")
    public ResponseEntity<SectorDto> updateSect(@PathVariable Long id, @RequestBody Sector sect){
        return ResponseEntity.ok(this.service.updateSect(id, sect));
    }
// update another version of updating again using Dto
    @PutMapping("/updateSect2")
    public ResponseEntity<SectorDto> updateSect2(@PathParam("id") Long id, @RequestBody Sector sect){
        return ResponseEntity.ok(this.service.updateSect(id, sect));
    }
 // Deleting employee again takes a path variable of Long Id but using the the ? because boolean
    @DeleteMapping("/deleteSect/{id}")
    public ResponseEntity<?> deleteSect(@PathVariable Long id){
        return this.service.deleteSect(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @PatchMapping("/addEmpToSect/{id}")
    public ResponseEntity<SectorDto> addEmpToSect(@PathVariable Long id, @RequestBody Employee emp){
        return new ResponseEntity<SectorDto>(this.service.addEmpToSect(id,emp), HttpStatus.ACCEPTED);
    }



}