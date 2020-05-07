package com.qa.service;


import com.qa.domain.Employee;
import com.qa.dto.EmployeeDto;
import com.qa.repo.empRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceIntegrationTest {
    @Autowired
    private EmpService service;

    @Autowired
    private empRepository repo;

    @Autowired
    private ModelMapper mapper;

    private Employee testEmp;

    private Employee testEmpWithId;

    private EmployeeDto mapToDto(Employee emp){
        return this.mapper.map(emp, EmployeeDto.class);
    }

    @Before
    public void setUp(){
        this.testEmp = new Employee("Tom","Engineer",5L);
        this.repo.deleteAll();
        this.testEmpWithId = this.repo.save(this.testEmp);
    }

    @Test
    public void readEmpTest(){
        assertThat(this.service.readEmp())
                .isEqualTo(
                        Stream.of(this.mapToDto(testEmpWithId)).collect(Collectors.toList())
                );
    }     // calling the read method of service is equal to our test emp in list

    @Test
    public void createEmpTest(){
        assertEquals(this.mapToDto(this.testEmpWithId),this.service.createEmp(testEmp));
    }  //test emp(id) as dto is the same as calling actual create method of service on test emp

    @Test
    public void findEmpByIdTest(){
        assertThat(this.service.findEmpById(this.testEmpWithId.getId()))
                .isEqualTo(this.mapToDto(this.testEmpWithId));
    } //calling findbyID of actual service should return the test emp with that id

    @Test
    public void deleteEmpTest(){
        assertThat(this.service.deleteEmp(this.testEmpWithId.getId()))
                .isFalse();
    }
} // if you call actual delete method on the id of the test emp with id and you expect false
