package com.demo.controller;

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
    public ResponseEntity<String> insertEmployee(@ModelAttribute("insertEmployee") Employee emp) {
        // Perform server-side validation
        if (!isValidEmployee(emp)) {
            return ResponseEntity.badRequest().body("Invalid employee data");
        }
        
        // Validation passed, save the employee
        employeeService.addEmp(emp);
        
        return ResponseEntity.ok("Employee added successfully");
    }

    // Server-side validation logic
    private boolean isValidEmployee(Employee emp) {
        // Implement your validation logic here
        return isValidName(emp.getName()) && isValidEmail(emp.getEmail());
    }

    private boolean isValidName(String name) {
        // Example: Name should not be empty
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        // Example: Check for a valid email format
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
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
