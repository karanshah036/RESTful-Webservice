package com.springDemo.springBoot.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
//Using Data it constructs getters, setter, required args constructor,to string. equals and hashcode methods
@Data
//@Getter
//@Setter
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentID;
    // Validating departname. If department name is not provided it will throw this msg.
    @NotBlank(message = "Please provide department name")
//    @Length(max=5,min = 1)
//    @Size(max=10,min=0)
//    @Email
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


//    public Department() {
//    }
//
//    public Department(Long departmentID, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentID = departmentID;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    public Long getDepartmentID() {
//        return departmentID;
//    }
//
//    public void setDepartmentID(Long departmentID) {
//        this.departmentID = departmentID;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentID='" + departmentID + '\'' +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
