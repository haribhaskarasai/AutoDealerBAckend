package com.auto.dealeraudit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auto.dealeraudit.entity.User;


@Repository 
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public  User findByMailId(String mailId);
	
	@Modifying
	@Query(value="UPDATE user u SET u.password=?1 WHERE u.mail_id=?2", nativeQuery = true)
	public void updateUserPassword(String password, String mailId);
	

}
