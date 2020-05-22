package com.thyme.controller;

import com.thyme.entity.Employee;
import com.thyme.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @GetMapping("/list")
  public String listEmployees(Model model) {

    List<Employee> employees = employeeService.getEmployees();

    model.addAttribute("employees", employees);

    return "employees/list-employees";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {

    Employee employee = new Employee();

    model.addAttribute("employee", employee);

    return "employees/employee-form";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

    Employee employee = employeeService.getEmployee(id);

    model.addAttribute("employee", employee);

    return "employees/employee-form";
  }

  @GetMapping("/delete")
  public String showFormForUpdate(@RequestParam("employeeId") int id) {

    employeeService.delete(id);

    return "redirect:/employees/list";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {

    employeeService.saveOrUpdate(employee);

    return "redirect:/employees/list";
  }


}
