package com.auto.dealeraudit.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "country")
public class Country {
	@Id
	private int id;
	@Column(name = "countryname")
	private String countryname;
}
