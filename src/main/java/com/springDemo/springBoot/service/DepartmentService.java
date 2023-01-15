package com.springDemo.springBoot.service;

import com.springDemo.springBoot.entity.Department;
import com.springDemo.springBoot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department getDepartmentByID(Long departmentID) throws DepartmentNotFoundException;

    public void deleteDepartmentbyID(Long departmentID);

    public Department updateDepartment(Long departmentID, Department department) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName);

}
