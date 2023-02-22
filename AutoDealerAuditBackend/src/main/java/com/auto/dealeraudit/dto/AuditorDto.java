package com.auto.dealeraudit.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditorDto {
	
	private int auditorId;
	private int rsa;
	private int sales;
	private int warranty;
	private String firstName;
	private String lastName;
	private String country;
	private String state;
	private String city;
	

}
