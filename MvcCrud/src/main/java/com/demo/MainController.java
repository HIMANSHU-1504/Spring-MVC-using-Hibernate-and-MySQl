package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/redirect")
	public String viewHome() {
		System.out.print("Fegrgwgwsgvwsg_________");
		
		return "/home";
	}

}
