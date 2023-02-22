package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.DealerAddress;


@Repository 
public interface DealerAddressRepository extends JpaRepository<DealerAddress, Integer> {

}
