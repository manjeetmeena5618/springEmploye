package com.example.spring.services;


import com.example.spring.dao.EmployeeRepository;
import com.example.spring.entity.EmployeEntity;
import com.example.spring.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeEntity save(EmployeEntity newEmploye) {

        return employeeRepository.save(newEmploye);
    }


    public List<EmployeEntity> getAllEmployees() {
        List<EmployeEntity> students = (List<EmployeEntity>) employeeRepository.findAll();
        return students;
    }

    public EmployeEntity getById(Integer id) {
        Optional<EmployeEntity> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Data Not Found");
        }
    }

    public EmployeEntity updateEmployee(Integer id, EmployeEntity empDetails) {
        Optional<EmployeEntity> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            EmployeEntity newUpdate =optional.get();
            newUpdate.setEmployeName(empDetails.getEmployeName());
            newUpdate.setUniversity(empDetails.getUniversity());
            return newUpdate;
        }else{
            throw new NotFoundException("Data Not Found");
        }
    }

    public Integer deleteEmp(Integer id) {
        Optional<EmployeEntity> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            EmployeEntity newUpdate =optional.get();
            newUpdate.setDeleted(true);
            return newUpdate.getId();
        }else{
            throw new NotFoundException("Data Not Found");
        }
    }
}
