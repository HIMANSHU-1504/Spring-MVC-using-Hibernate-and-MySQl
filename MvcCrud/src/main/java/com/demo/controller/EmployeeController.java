package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Employee;
import com.demo.service.EmployeeServices;
import com.demo.validator.EmployeeValidator;

@Controller
@RequestMapping
public class EmployeeController {

	@Autowired
	EmployeeServices employeeService;
		
	// add employee
	@GetMapping("addEmployee")
	public String addEmp() {
		
		return "AddEmployee";
	}	
	
	// Save Employee
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp, Model model) {
	    List<String> missingFields = EmployeeValidator.getMissingFields(emp);

	    if (!missingFields.isEmpty()) {
	        model.addAttribute("missingFields", missingFields);
	        return "AddEmployee"; // Redirect back to the AddEmployee page
	    }

	    // Validation passed, save the employee
	    employeeService.addEmp(emp);

	    return "redirect:/employeeReport"; // Redirect on successful addition
	}

    
	//load employee Data
	//	passing data thats why use model
	
	@GetMapping("employeeReport")
	public String loadEmployee(Model m) {
		m.addAttribute("employee", employeeService.getAllEmp());
		m.addAttribute("title", "EmployeeReport");
		return "EmployeeReport";
	}
	
	//	edit form
	@GetMapping("/editEmployee/{id}")
	
	//	for getting url variable we are using path variable annotation
	public String loadEditForm(@PathVariable(value = "id") Long id, Model m) {
		
		Employee emp = employeeService.getById(id);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "EditEmployee");
		
		return "EditEmployee";
		
	}

	//update Employee
	
	@PostMapping("/editEmployee/updateEmployee")
    public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
		
		employeeService.updateEmp(emp);
		
		return "redirect:/employeeReport";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		
		return "redirect:/employeeReport";
	}
	

}
