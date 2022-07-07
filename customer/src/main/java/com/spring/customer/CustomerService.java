package com.spring.customer;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service	
public class CustomerService {

	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Customer> listAllCustomers() {
		return repository.findAll();		
	}
	
	
	public void registerCustomer(Customer customer) {
		
		repository.saveAndFlush(customer);
		
		//check if customer is fraudster
		Boolean isFraud = restTemplate.getForObject(
				"http://FRAUD/fraud-check/{customerId}", 
				Boolean.class,
				customer.getId()
				);
		
		if(isFraud) {
			System.out.println("Customer is Fraud!!!!!");
		}else {
			System.out.println("Customer Saved!!!!!");
			repository.save(customer);
		}		
	}
	
	@PostConstruct
	public void saveCustomers() {
		repository.saveAll(List.of(new Customer(1, "pradeep", "s", "pradeep@gmail.com"),
				new Customer(2, "sujitha", "s", "sujitha@gmail.com")));
	}

}
