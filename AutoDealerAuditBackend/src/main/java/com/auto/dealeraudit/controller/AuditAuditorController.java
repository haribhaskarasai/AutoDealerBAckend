package com.auto.dealeraudit.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.dealeraudit.entity.AuditAuditor;
import com.auto.dealeraudit.repository.AuditAuditorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/auditorWorkAssign/v1")
public class AuditAuditorController {
	
	@Autowired
	private AuditAuditorRepository auditAuditorRepository;
	
	@PostMapping(value="auditorWork")
	public AuditAuditor createAuditAuditor(@RequestBody AuditAuditor auditAuditor) {
		return auditAuditorRepository.save(auditAuditor);
		
	};

}
