package com.qa.service;

import com.qa.domain.Employee;
import com.qa.dto.EmployeeDto;
import com.qa.exception.EmployeeNotFoundException;
import com.qa.repo.empRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceUnitTest {
    @InjectMocks
    private EmpService service; // This is what you are mocking and will be where dependencies are injected

    @Mock
    private empRepository repo;  // this is one of the declarations and in the constructor
    @Mock
    private ModelMapper mapper; // same reason as above

    private List<Employee> empList; // we need a list as this is involved in the methods and part of tests

    private Employee testEmp; // this will be your employee variable

    private Long id = 1L; // the test version wont have an id therefore we need to create our own

    private Employee testEmpWithId;  // this will be the employee with ID

    private EmployeeDto empDto; // remember our results get converted into Dto so will do this as the expected

    private EmployeeDto mapToDto(Employee emp){             // this what allows us to convert to Dto object
        return this.mapper.map(emp, EmployeeDto.class);
    }

    @Before  // this is how we set up our test and set up some situation
    public void setUp(){
        this.empList = new ArrayList<>(); // new empty list for when we look at CRUD methods
        this.testEmp = new Employee("tom","Accountant",5L); //setting a employee
        this.empList.add(testEmp); // add this to the list
        this.testEmpWithId = new Employee(testEmp.getName(),testEmp.getJobTitle(),testEmp.getContLength());
        // apply those details to one which we will give an ID to
        this.testEmpWithId.setId(id); // give the id we created to the test employee with an id
        this.empDto=this.mapToDto(testEmpWithId); // remember the employee needs to be DTO
    }

    @Test
    public void getAllEmpTest(){
        when(repo.findAll()).thenReturn(this.empList); //list is returned when findall method called on repo
        when(this.mapper.map(testEmpWithId, EmployeeDto.class)).thenReturn(empDto); //test emp becomes Dto
        assertFalse("Service returned none", this.service.readEmp().isEmpty()); //list not empty
        verify(repo,times(1)).findAll(); //repo findAll is called in repo
    }

    @Test
    public void createEmpTest(){
        when(repo.save(testEmp)).thenReturn(testEmpWithId); //when you save it creates test emp with ID
        when(this.mapper.map(testEmpWithId, EmployeeDto.class)).thenReturn(empDto); //testempID becomes DTO
        assertEquals(this.service.createEmp(testEmp),this.empDto); //creating test emp results in empDto therefore
        verify(repo,times(1)).save(testEmp); //save called once on testEmp
    }

    @Test
    public void findEmpById(){
        when(repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testEmpWithId)); //should get empWithID
        when(this.mapper.map(testEmpWithId, EmployeeDto.class)).thenReturn(empDto); //testempid to DTO
        assertEquals(this.service.findEmpById(this.id),empDto); //therefore returns the empDto
        verify(repo,times(1)).findById(id); //findbyId called only once
    }

    @Test
    public void deleteNoteExistingID(){
        when(this.repo.existsById(id)).thenReturn(true,false); //could be true or false
        assertFalse(service.deleteEmp(id)); //it checks for it after so should be false
        verify(repo,times(1)).deleteById(id); //delete called once
        verify(repo, times(2)).existsById(id); // checks start and after so twice
    }

    @Test(expected = EmployeeNotFoundException.class) // wont work on line 92 hence we expect this
    public void deleteNonExistingId(){
        when(this.repo.existsById(id)).thenReturn(false); //doesnt exist
        service.deleteEmp(id); // call the id
        verify(repo, times(1)).existsById(id); // use this once
    }








}
