package com.springDemo.springBoot.controller;


import com.springDemo.springBoot.entity.Department;
import com.springDemo.springBoot.error.DepartmentNotFoundException;
import com.springDemo.springBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @GetMapping("/departments/{id}")
    //{id} -> is called path variable we can get reference to it by using @PathVariable
    public Department getDepartmentByID(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByID(departmentID);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentID){
        departmentService.deleteDepartmentbyID(departmentID);
        return "Department delted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID,
                                       @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.updateDepartment(departmentID,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
