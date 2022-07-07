package com.spring.fraud;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FraudCheckHistory {
	
	@Id
	@SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
	private Integer id;
	private Integer customerId;
	private Boolean isFraudster;
	private LocalDateTime createdAt;
	public FraudCheckHistory(Integer customerId, Boolean isFraudster, LocalDateTime createdAt) {
		super();
		this.customerId = customerId;
		this.isFraudster = isFraudster;
		this.createdAt = createdAt;
	}
	public FraudCheckHistory() {
		super();
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Boolean getIsFraudster() {
		return isFraudster;
	}
	public void setIsFraudster(Boolean isFraudster) {
		this.isFraudster = isFraudster;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
