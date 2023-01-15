package com.springDemo.springBoot.service;

import com.springDemo.springBoot.entity.Department;
import com.springDemo.springBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Mumbai")
                        .departmentCode("IT-06")
                        .departmentID(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void whenValidatDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}