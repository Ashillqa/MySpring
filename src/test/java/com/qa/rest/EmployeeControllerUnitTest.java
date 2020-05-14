package com.qa.rest;

import com.qa.domain.Employee;
import com.qa.dto.EmployeeDto;
import com.qa.rest.EmployeeController;
import com.qa.service.EmpService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerUnitTest {
    @InjectMocks
    private EmployeeController empCont;
    @Mock
    private EmpService empService;

    private List<Employee> emps;
    private Employee testEmp;
    private Employee testEmpWithId;
    private Employee newEmp;
    private Employee updateEmp;
    private Long id = 1L;
    private EmployeeDto empDto;
    private final ModelMapper mapper = new ModelMapper();
    private EmployeeDto mapToDto(Employee emp){return this.mapper.map(emp,EmployeeDto.class);}

    @Before
    public void setUp(){
        this.emps=new ArrayList<>();
        this.testEmp= new Employee("name",3L);
        this.emps.add(testEmp);
        this.testEmpWithId = new Employee(testEmp.getName(),testEmp.getCerts());
        this.testEmpWithId.setId(this.id);
        this.empDto = this.mapToDto(testEmpWithId);
    }

    @Test
    public void getAllEmpsTest(){
        when(empService.readEmp()).thenReturn(this.emps.stream().map(this::mapToDto).collect(Collectors.toList()));
        assertFalse("No emps found", this.empCont.getAllEmps().getBody().isEmpty());
        verify(empService, times(1)).readEmp();
    }

    @Test
    public void createNoteTest(){
        when(this.empService.createEmp(testEmp)).thenReturn(this.empDto);
        assertEquals(this.empCont.createEmp(testEmp), new ResponseEntity<EmployeeDto>(this.empDto, HttpStatus.CREATED));
        verify(this.empService, times(1)).createEmp(testEmp);
    }

    @Test
    public void deleteNoteTestFalse(){
        this.empCont.deleteEmp(id);
        verify(empService, times(1)).deleteEmp(id);
    }

    @Test
    public void deleteEmpTestTrue(){
        when(empService.deleteEmp(1L)).thenReturn(true);
        this.empCont.deleteEmp(1L);
        verify(empService, times(1)).deleteEmp(1L);
    }

    @Test
    public void getEmpByIDTest(){
        when(this.empService.findEmpById(id)).thenReturn(this.empDto);
        assertEquals(this.empCont.empById(id), new ResponseEntity<EmployeeDto>(this.empDto, HttpStatus.OK));
        verify(empService, times(1)).findEmpById(id);
    }


     @Test
    public void updateTest(){
        when(this.empService.updateEmp(id,updateEmp)).thenReturn(empDto);
        assertEquals(this.empCont.updateEmp(id,updateEmp),new ResponseEntity<EmployeeDto>(this.empDto,HttpStatus.OK));
     }
}



























