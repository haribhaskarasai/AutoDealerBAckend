package com.auto.dealeraudit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "dealer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dealerId", nullable = false)
	private int dealerId; 	
	
	@NotEmpty(message = "Dealer Code Required")
	@Size(min = 5,max = 5,message = "Dealer Code must have 5 characters")
	@Column(name = "dealerCode", updatable = false, unique = true, nullable = false)
	private String dealerCode; 
	
	@NotEmpty(message = "Dealer Name Required")
	@Size(max = 34,message = "Dealer Name should not contain more than 34 characters")
	@Column(name = "dealerName", nullable = false , length = 34)
	private String dealerName;
	
	@NotEmpty(message = "business Center Required")
	@Size(max = 2,message = "BusinessCenter code can not be more than 2 character")
	@Column(name = "businessCenter", nullable = false, length = 2)
	private String businessCenter;
	
	@Size(max = 68,message = "DBA should not contain more than 68 characters")
	@Column(name = "dba", length = 68)
	private String dba;
	
	@NotEmpty(message = "Required Dealer Principal")
	@Size(max = 60,message = "Dealer Principal should not contain more than 60 characters")
	@Column(name = "dealerPrincipal", nullable = false , length = 60)
	private String dealerPrincipal;

	@NotEmpty(message = "Required Letter Greeting")
	@Size(max = 60,message = "Letter Greeting should not contain more than 60 characters")
	@Column(name = "letterGreeting", nullable = false , length = 60)
	private String letterGreeting;
	
	@NotNull(message = "Required Sales Group Size")
	//@Size(min = 1,max = 2,message = "Sales Group Size should be 1 character")
	@Column(name = "salesGroupSize", nullable = false)
	private char salesGroupSize;
	
	//@NotNull(message = "Required Dealer Address")
    @OneToOne(mappedBy = "dealer", cascade = CascadeType.ALL)
	private DealerAddress dealerAddress;
	
	@JsonManagedReference(value = "dealerAudit")
	@OneToMany(mappedBy = "dealer", cascade = CascadeType.MERGE)
	private List<Audit> audits;


	
}
