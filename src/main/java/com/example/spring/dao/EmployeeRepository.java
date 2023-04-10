package com.example.spring.dao;
import com.example.spring.entity.EmployeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeEntity, Integer>{


}
