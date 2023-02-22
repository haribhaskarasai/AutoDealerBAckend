package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.Audit;



@Repository 
public interface AuditRepository  extends JpaRepository<Audit, Integer> {
	
	public Audit findById(int auditId);

}
