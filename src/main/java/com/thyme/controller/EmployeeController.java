package com.thyme.controller;

import com.thyme.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private List<Employee> employees;

  @PostConstruct
  private void localData() {

    Employee emp1 = new Employee(1, "Dazz", "Kaminski", "dazz@gmail.com");

    employees = new ArrayList<>();

    employees.add(emp1);
  }

  @GetMapping("/list")
  public String listEmployees(Model model) {

    model.addAttribute("employees", employees);

    return "list-employees";
  }
}
