package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.AuditAuditor;



@Repository 
public interface AuditAuditorRepository extends JpaRepository<AuditAuditor , Integer> {

}
