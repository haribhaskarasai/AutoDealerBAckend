package com.auto.dealeraudit.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auto.dealeraudit.dto.UserCredentialsDto;
import com.auto.dealeraudit.dto.UserDto;
import com.auto.dealeraudit.entity.User;
import com.auto.dealeraudit.entity.UserAddress;
import com.auto.dealeraudit.service.EmailSenderService;
import com.auto.dealeraudit.service.UserService;
import com.auto.dealeraudit.utilities.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/user/v1")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	EmailSenderService emailSenderService;
	
	//AUTHENTICATE 	
	
	@PostMapping(value="/user/authenticate") public Map<String,String>
	  generateToken(@RequestBody UserCredentialsDto user){ 
		long timestamp =System.currentTimeMillis(); 
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS512,Constants.API_SECRET_KEY)
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
				.claim("userId",user.getUserId())
				.claim("userRole",user.getUserRole())
				.claim("mailId", user.getMailId())
				.compact();
		Map<String,String> map=new HashMap<>();
		map.put("JWT", token);
		return map;			
	  }
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	

	@PostMapping(value = "/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.ACCEPTED);

	}
	
	@PostMapping(value = "/userAddress")
	public ResponseEntity<UserAddress> createUserAddress(@Valid @RequestBody UserAddress userAddress) {

		return new ResponseEntity<UserAddress>(userService.createUserAddress(userAddress), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	
	@GetMapping(value="/users/otp/{mail}")
	public ResponseEntity<Integer> getOtp(@PathVariable("mail") String mail){
		userService.readUserByMailId(mail);
		return ResponseEntity.status(HttpStatus.OK).body(emailSenderService.sendEmail(mail));
	}

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<User> getUserById(@Valid @PathVariable("userId") int userId) {
		return new ResponseEntity<User>(userService.readUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{mailId}")
	public ResponseEntity<UserDto> getUserBymailId(@Valid @PathVariable("mailId") String mailId) {
		return new ResponseEntity<UserDto>(userService.readUserByMailId(mailId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.readAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/userAddresses")
	public ResponseEntity<List<UserAddress>> getAllUserAddresses() {
		return new ResponseEntity<List<UserAddress>>(userService.readAllUsersAddress(), HttpStatus.OK);
	}
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	@DeleteMapping(value = "/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("userId") int userId) {
		return new ResponseEntity<String>(userService.deleteById(userId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteUserAddress/{userAddresId}")
	public ResponseEntity<String> deleteUserAddress(@Valid @PathVariable("userAddresId") int userAddresId) {
		return new ResponseEntity<String>(userService.deleteByUserAddressId(userAddresId), HttpStatus.OK);
	}

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	

	@PutMapping(value = "/userUpdate/{user}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUserById(user), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/UserAddressUpdate/{userId}")
	public ResponseEntity<UserAddress> updateUserAddress(@Valid @PathVariable("userId") int userId,@Valid @RequestBody UserAddress userAddress) {
		return new ResponseEntity<UserAddress>(userService.updateUserAddressById(userId,userAddress), HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value = "/updatepassword/{password}/{mailId}")
	public ResponseEntity<UserDto> updateUserPassword(@Valid @PathVariable("password") String password,@Valid @PathVariable("mailId") String mailId  ) {
		return new ResponseEntity<UserDto>(userService.resetPassword(password, mailId), HttpStatus.ACCEPTED);

	}


}
