package com.auto.dealeraudit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.dealeraudit.dto.AuditDto;
import com.auto.dealeraudit.entity.Audit;
import com.auto.dealeraudit.entity.Dealer;
import com.auto.dealeraudit.repository.AuditAuditorRepository;
import com.auto.dealeraudit.service.AuditService;
import com.auto.dealeraudit.service.DealerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/audit/v1")
public class AuditController {
	
	@Autowired
	private AuditService auditService;
	
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private AuditAuditorRepository auditAuditorRepository;
	
	
	
	//Create Operations
	
	@PostMapping(value="/audit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Audit> createAudit(@RequestBody AuditDto inputAuditDto) {
		
		Dealer dealer= dealerService.getDealerById(inputAuditDto.getDealerId());
		Audit audit= new Audit(inputAuditDto.getAuditId(),inputAuditDto.getAuditType(),inputAuditDto.getDateAssigned(),inputAuditDto.getReason(),inputAuditDto.getReportsLanguage(),inputAuditDto.getNoOfMonths(),inputAuditDto.getComments(),dealer,inputAuditDto.getAuditAuditors());
		Audit resAudit=auditService.createAudit(audit);
		return new ResponseEntity<Audit>(resAudit,HttpStatus.ACCEPTED);
	}
	
	//Read Operations
	
	@GetMapping(value = "/audits/{auditId}")
	public ResponseEntity<Audit> getAuditById(@Valid @PathVariable("auditId") int auditId) {
		return new ResponseEntity<Audit>(auditService.getAuditDetails(auditId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/audits")
	public ResponseEntity<List<Audit>> getAudits() {
		return new ResponseEntity<List<Audit>>(auditService.getAllAuditDetails(), HttpStatus.OK);
	}
	
	//Update Operations
	
	
	
	

}
