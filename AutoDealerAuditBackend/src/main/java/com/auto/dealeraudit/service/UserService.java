package com.auto.dealeraudit.service;

import java.util.List;

import com.auto.dealeraudit.dto.UserDto;
import com.auto.dealeraudit.entity.User;
import com.auto.dealeraudit.entity.UserAddress;
import com.auto.dealeraudit.exception.CustomException;

public interface UserService {

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public User createUser(User user) throws CustomException;

    /*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public User readUserById(int userId) throws CustomException;
	public UserDto readUserByMailId(String mailId) throws CustomException;
	public  List<User>  readAllUsers() throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public User updateUserById(User user) throws CustomException; // update
	
	public UserDto resetPassword(String password, String mailId) throws CustomException;
	
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteById(int userId) throws CustomException;
	
	public String deleteByMailIdAndPassword(String mailId,String password) throws CustomException;
	
	/*
	 * *********************************************************
	 * 
	 *                    User address service 
	 *                    
	 * *********************************************************
	 */

	public UserAddress updateUserAddressById(int userId,UserAddress userAddress) throws CustomException; // update
	
	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	
	public  List<UserAddress>  readAllUsersAddress() throws CustomException;

	
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */

	public UserAddress createUserAddress(UserAddress userAddress) throws CustomException;
	 
	

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	
	public String deleteByUserAddressId(int userAddressId) throws CustomException;

}
