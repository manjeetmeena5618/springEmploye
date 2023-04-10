package com.example.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class EmployeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String employeName;
    private String university;
    private int year;
    private int percentage;
    private String gender;
    private String currentAddress;
    private String permanentAddress;
    private String district;
    private int pincode;
    private String branch;
    private Boolean deleted;
}
