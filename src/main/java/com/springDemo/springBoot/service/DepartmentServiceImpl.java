package com.springDemo.springBoot.service;

import com.springDemo.springBoot.entity.Department;
import com.springDemo.springBoot.error.DepartmentNotFoundException;
import com.springDemo.springBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentID);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not present");
        }
        else
            return department.get();
    }

    @Override
    public void deleteDepartmentbyID(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) throws DepartmentNotFoundException {
        Department depB = getDepartmentByID(departmentID);

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }



}
