package com.auto.dealeraudit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.dealeraudit.dto.AuditorDto;
import com.auto.dealeraudit.entity.Auditor;
import com.auto.dealeraudit.service.AuditorService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/auditor/v1")
public class AuditorController {
	
	@Autowired
	private AuditorService auditorService;
	
	@PostMapping(value = "auditor")
	public ResponseEntity<Auditor> createAuditor(@RequestBody Auditor auditor) {
		return new ResponseEntity<Auditor>(auditorService.createAuditor(auditor),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "auditors/{auditorId}")
	public ResponseEntity<Auditor> getById(@PathVariable int auditorId) {
		return new ResponseEntity<Auditor>(auditorService.getAuditorByid(auditorId),HttpStatus.OK);
	}
	
	@GetMapping(value = "auditors")
	public ResponseEntity<List<AuditorDto>>  getAllAuditors(){
		
		return new ResponseEntity<List<AuditorDto>>(auditorService.getAllAuditors(),HttpStatus.OK);
	}


}
