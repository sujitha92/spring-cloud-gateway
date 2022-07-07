package com.spring.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping
	public void registerCustomer(@RequestBody Customer customer) {
		System.out.println("New Customer Registration.........");		
		service.registerCustomer(customer);

	}
	@GetMapping
	public List<Customer> listCustomers() {	
		return service.listAllCustomers();

	}
	
}
