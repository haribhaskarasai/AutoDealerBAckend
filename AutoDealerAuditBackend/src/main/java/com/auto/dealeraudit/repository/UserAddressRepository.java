package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.UserAddress;


@Repository 
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

}
