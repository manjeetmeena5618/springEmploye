package com.example.spring.controller;

import com.example.spring.dao.EmployeeRepository;
import com.example.spring.entity.EmployeEntity;
import com.example.spring.services.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class Registration {

    private static final Logger logger = LoggerFactory.getLogger(Registration.class);
    @Autowired
    RegistrationService registrationService;


    @PostMapping("employee/registration")
    public EmployeEntity save(@RequestBody EmployeEntity newEmploye) {
        newEmploye = registrationService.save(newEmploye);
        return newEmploye;
    }

    @GetMapping("employees/all")
    public List<EmployeEntity> getAllEmp() {
        List<EmployeEntity> list = registrationService.getAllEmployees();
        return list;
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeEntity> getEmployeeById(@PathVariable("id") Integer id){
        EmployeEntity dbObject = registrationService.getById(id);
        return ResponseEntity.ok().body(dbObject) ;
    }

    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable("id") Integer id) {
        registrationService.deleteEmp(id);
    }

    @RequestMapping(value="/employees/{id}", method=RequestMethod.PUT)
    public ResponseEntity<EmployeEntity> readEmp(@PathVariable(value = "id") Integer id, @RequestBody EmployeEntity empDetails) {
        EmployeEntity dbObj =  registrationService.updateEmployee(id, empDetails);
        return ResponseEntity.ok().body(dbObj);
    }

    @GetMapping("/string")
    public String getString() {
        System.out.println("hghgh");
        return "hello";
    }
}
