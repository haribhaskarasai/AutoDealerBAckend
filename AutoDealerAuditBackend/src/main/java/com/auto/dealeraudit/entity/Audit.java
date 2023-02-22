package com.auto.dealeraudit.entity;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Table(name = "audit")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId", nullable = false)
	private int auditId;
	
	@NotNull(message = "Choose Audit Type")
	@Column(name = "auditType")
	private AuditType auditType;

	public enum AuditType {
		RSA, SALES, WARRANTY
	}

	//@NotEmpty(message = "Date Assigned Required")
	@Column(name = "dateAssigned", nullable = false, length = 15)
	private LocalDate dateAssigned;

	@NotEmpty(message = "Reason Required")
	@Column(name = "reason", nullable = false, length = 255)
	private String reason;

	@NotNull(message = "Choose Report Language")
	@Column(name = "reportsLanguage")
	private ReportsLanguage reportsLanguage;

	public enum ReportsLanguage {
		ENGLISH, SPANISH, FRENCH
	}

	//@NotEmpty(message = "No Of Months Required")
	@Column(name = "noOfMonths", nullable = false, length = 2)
	private int noOfMonths;

	@Column(name = "comments", length = 500)
	private String comments;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dealerId", referencedColumnName = "dealerId")
	@JsonBackReference(value = "dealerAudit")
	private Dealer dealer;

	@JsonManagedReference(value = "auditTOJunctionTable")
	@OneToMany(mappedBy = "audit", cascade = CascadeType.ALL)
	private List<AuditAuditor> auditAuditors;

	public Audit(int auditId, @NotNull(message = "Choose Audit Type") AuditType auditType, LocalDate dateAssigned,
			@NotEmpty(message = "Reason Required") String reason,
			@NotNull(message = "Choose Report Language") ReportsLanguage reportsLanguage, int noOfMonths,
			String comments, Dealer dealer) {
		super();
		this.auditId = auditId;
		this.auditType = auditType;
		this.dateAssigned = dateAssigned;
		this.reason = reason;
		this.reportsLanguage = reportsLanguage;
		this.noOfMonths = noOfMonths;
		this.comments = comments;
		this.dealer = dealer;
	}
	
	

}
