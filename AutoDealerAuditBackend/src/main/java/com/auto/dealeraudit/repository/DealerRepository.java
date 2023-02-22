package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

	public Dealer findByDealerCode(String dealerCode);

	public Dealer findByDealerName(String dealerName);

	public Dealer findByBusinessCenter(String businessCenter);

}
