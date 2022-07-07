package com.spring.fraud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud-check")
public class FraudController {
	
	@Autowired
	FraudService service;
	
	@GetMapping(path="{customerId}")
	public Boolean isFraud(@PathVariable("customerId") Integer id) {
		
		boolean isFraud=service.isFraud(id);	
		return isFraud;
	}
	@GetMapping
	public List<FraudCheckHistory> listAllFraud() {
		return service.listAllFraud();
	}
	
	

}
