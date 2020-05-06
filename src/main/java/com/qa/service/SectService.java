package com.qa.service;

import com.qa.domain.Employee;
import com.qa.domain.Sector;
import com.qa.dto.SectorDto;
import com.qa.exception.SectorNotFoundException;
import com.qa.repo.empRepository;
import com.qa.repo.sectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectService {
    private final sectRepository repo;
    private final empRepository empRepo;
//model mapper final
    private final ModelMapper mapper;
//constructor method Autowired and added mapper to the constructor
    @Autowired
    public SectService(sectRepository repo, empRepository empRepo, ModelMapper mapper) {
        this.repo = repo;
        this.empRepo = empRepo;
        this.mapper=mapper;
    }
 // add the converter to Dto for this service just like employee
    private SectorDto mapToDto(Sector sector){
        return this.mapper.map(sector, SectorDto.class);
    }
//read all Employees using the findall() but converting using the map to dto
    public List<SectorDto> readSect(){
        return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }
// create an Employee using the repo.save() and again make it pf type Dto
    public SectorDto createSect(Sector sect){
        return this.mapToDto(this.repo.save(sect));
    }
// find a repo by ID and also introduce new Exception - will help when updating and deleting again map to dto type
    public SectorDto findSectById(Long id){
        return this.mapToDto(this.repo.findById(id).orElseThrow(SectorNotFoundException::new));
    }
// Now we can check Id when updating an employee
    public SectorDto updateSect(Long id, Sector sect){
        Sector update = this.repo.findById(id).orElseThrow(SectorNotFoundException::new);
        update.setDescription(sect.getDescription());
        update.setEmployee(sect.getEmployee());
        Sector tempSect = this.repo.save(update);
        return this.mapToDto(tempSect);
    }
 // Delete an employee again by first checking the ID actually exists
    public boolean deleteSect(Long id){
        if(!this.repo.existsById(id)){
            throw new SectorNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

    public SectorDto addEmpToSect(Long id, Employee emp){
        Sector sect = this.repo.findById(id).orElseThrow(SectorNotFoundException::new);
        Employee tmp = this.empRepo.save(emp);
        sect.getEmployee().add(tmp);
        return this.mapToDto(this.repo.saveAndFlush(sect));
    }
}
