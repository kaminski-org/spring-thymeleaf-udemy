package com.thyme.service;

import com.thyme.entity.Employee;
import com.thyme.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;

  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployee(int id) {
    return employeeRepository.findById(id).get();
  }

  public void saveOrUpdate(Employee employee) {
    employeeRepository.save(employee);
  }

  public void delete(int id) {
    employeeRepository.deleteById(id);
  }
}
