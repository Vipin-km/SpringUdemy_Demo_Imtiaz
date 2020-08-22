package com.example.vipin.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vipin.domain.Products;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User found: " +userId;
	}
	
	@RequestMapping("/{userId}/invoices")
	public String displayUserInvoices(@PathVariable int userId,
			@RequestParam(value="date", required =false) Date dateorNull ) {
		return "Invoice found for User found: " +userId+ "on the date: " +dateorNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shoes", "bag", "button");
		
	}
	
	@RequestMapping("/{userId}/products")
	public List<Products> displayProductsJson() {
		return Arrays.asList(new Products(1,"bag", 46.33),
				new Products(1,"shoes", 6.33),
				new Products(1,"doll", 47.33));
		
	}
	
}
