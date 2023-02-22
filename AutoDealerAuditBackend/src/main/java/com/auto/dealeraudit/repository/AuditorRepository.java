package com.auto.dealeraudit.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.auto.dealeraudit.entity.Auditor;



@Repository 
public interface AuditorRepository extends JpaRepository<Auditor, Integer> {
	
	public abstract Auditor findById(int auditorId);
	
	
	@Query(value="SELECT a.auditor_id, a.rsa, a.sales, a.warranty, u.last_name, u.first_name,ua.country, ua.state, ua.city FROM auditor a INNER JOIN user u ON a.user_id=u.user_id INNER JOIN user_address ua ON u.user_id = ua.user_id;",nativeQuery = true)
	public abstract List<Tuple> findAllAuditors();

}
