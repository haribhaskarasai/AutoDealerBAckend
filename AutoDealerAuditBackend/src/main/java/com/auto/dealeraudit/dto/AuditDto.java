package com.auto.dealeraudit.dto;

import java.time.LocalDate;
import java.util.List;



import com.auto.dealeraudit.entity.AuditAuditor;
import com.auto.dealeraudit.entity.Audit.AuditType;
import com.auto.dealeraudit.entity.Audit.ReportsLanguage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditDto {

	private int auditId;
	private AuditType auditType;
	private LocalDate dateAssigned;
	private String reason;
	private ReportsLanguage reportsLanguage;
	private int noOfMonths;
	private String comments;
	private int dealerId;
	private List<AuditAuditor> auditAuditors;

}
