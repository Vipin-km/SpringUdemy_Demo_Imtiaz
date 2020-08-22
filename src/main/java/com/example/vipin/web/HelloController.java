package com.example.vipin.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting") //, method = RequestMethod.GET
public class HelloController {
	
	@RequestMapping(value = "basic")
	public String sayHello() {
		return "<h1>Hello</h1>";
	}
	
	@RequestMapping(value = "proper")
	public String sayProperHello() {
		return "<h1>Hello there! How are you</h1>";
	}

	@RequestMapping(value = "/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method=\"GET\">\r\n" + 
		"  <label for=\"fname\">First name:</label><br>\r\n" + 
		"  <input type=\"text\" id=\"fname\" name=\"firstName\"><br>\r\n" + 
		"  <label for=\"lname\">Last name:</label><br>\r\n" + 
		"  <input type=\"text\" id=\"lname\" name=\"lastName\"><br><br>\r\n" + 
		"  <input type=\"submit\" value=\"Submit\">\r\n" + 
		"</form> ";
	}
	
	@RequestMapping(value = "/user_greeting", method= RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstName, @RequestParam String lastName) {
		return "<h1> Hello There! </h1>" +firstName+ " " +lastName + "<b> Form subitted ;)</b>";
	}
	
	@RequestMapping(value = "/order/{id}", method= RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID: " +id;
		
	}
}
