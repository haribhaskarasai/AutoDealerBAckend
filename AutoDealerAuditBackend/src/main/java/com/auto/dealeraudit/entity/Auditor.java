package com.auto.dealeraudit.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bharathp
 *
 */
@Entity
@Table(name = "auditor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditorId", nullable = false)
	private int auditorId;
	
	
	//@NotEmpty(message = "RSA Required")
	@Column(name = "rsa", nullable = false,columnDefinition = "integer default 0")
	private int rsa;
	
	//@NotEmpty(message = "Sales Required")
	@Column(name = "sales", nullable = false,columnDefinition = "integer default 0")
	private int sales;
	
	//@NotEmpty(message = "Warranty Required")
	@Value("${some.key:0}")
	@Column(name = "warranty",nullable = false)
	private int warranty;
	
	@NotNull(message = "User Details Required")
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @JsonBackReference(value = "userTOAuditor")
	private User user;
	
	//@NotNull(message = "Required Auditor Details")
	@JsonManagedReference(value = "auditorTOJunctionTable")
	@OneToMany(mappedBy = "auditor", cascade = CascadeType.ALL)
	private List<AuditAuditor> auditAuditors;
	
	

	
}
