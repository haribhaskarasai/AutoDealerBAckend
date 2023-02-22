package com.auto.dealeraudit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userAddress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userAddressId", updatable = false, nullable = false)
	private int userAddressId;

	@NotEmpty(message = "Mail Required")
	@Email(message = "Not a Valid Email",regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "mail", nullable = false, length = 500)
	private String mail;

	@NotEmpty(message = "Required Address Lane 1")
	@Size(max = 255,message = "Address should be less than 255 characters")
	@Column(name = "addressLane1", nullable = false, length = 255)
	private String addressLane1;

	@Size(max = 255,message = "Address should be less than 255 characters")
	@Column(name = "addressLane2", length = 255)
	private String addressLane2;

	@NotEmpty(message = "Required City")
	@Size(max = 50,message = "City should be less than 50 characters")
	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@NotEmpty(message = "Required State")
	@Size(max = 50,message = "State should be less than 50 characters")
	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@NotEmpty(message = "Required Country")
	@Size(max = 50,message = "Country should be less than 50 characters")
	@Column(name = "country", nullable = false, length = 50)
	private String country;

	@NotEmpty(message = "Required Zip")
	@Size(max = 10,message = "Zip Code should be less than 10 characters")
	@Column(name = "zip", nullable = false, length = 10)
	private String zip;

	@NotEmpty(message = "Required Phone")
	@Size(max = 15,message = "Phone Code should be less than 15 characters")
	@Column(name = "phone", nullable = false, length = 15)
	private String phone;
	
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	
	
}
