package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/Register")
	public String viewRegister() {
		System.out.print("Fegrgwgwsgvwsg_________");
		
		return "AddEmployee";
	}

}
