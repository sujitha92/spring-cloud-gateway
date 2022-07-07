package com.spring.fraud;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudService {
	

	@Autowired
	FraudCheckHistoryRepository repository;
	
	public boolean isFraud(Integer id) {
		
		
		FraudCheckHistory fraudCheckHistory=new FraudCheckHistory(id, false, LocalDateTime.now());
		repository.save(fraudCheckHistory);
		
		return false;
		
	}

	public List<FraudCheckHistory> listAllFraud() {		
		return repository.findAll();
	}
	
	@PostConstruct
	public void saveFraudHistory() {
		repository.saveAll(List.of(new FraudCheckHistory(1, false, LocalDateTime.now()),
				new FraudCheckHistory(2, false, LocalDateTime.now())));
	}

}
