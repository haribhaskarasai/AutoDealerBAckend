package com.auto.dealeraudit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialsDto {
	
	private int userId;
	private String userRole;
	private String mailId;

}
