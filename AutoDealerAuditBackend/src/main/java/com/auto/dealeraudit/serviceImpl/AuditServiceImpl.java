package com.auto.dealeraudit.serviceImpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.entity.Audit;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.AuditRepository;
import com.auto.dealeraudit.service.AuditService;



/**
 * @author bharathp
 *
 */
@Service
@Transactional 
public class AuditServiceImpl implements AuditService {
	
	@Autowired
	private AuditRepository auditRepo;
	

	@Override
	public Audit createAudit(Audit audit) throws CustomException {
		if(auditRepo.existsById(audit.getAuditId())) {
			throw new CustomException("Audit already exits");
		}
		return auditRepo.save(audit);	
	}

	@Override
	public Audit getAuditDetails(int auditId) throws CustomException {
		if (auditRepo.existsById(auditId)) {
			return auditRepo.findById(auditId);
		} else {
			throw new CustomException("Audit does not exits");

		}
	}

	@Override
	public List<Audit> getAllAuditDetails() throws CustomException {
		if (auditRepo.findAll().isEmpty()) {
			throw new CustomException("There are no Audits exits");
		} else {
			return auditRepo.findAll();

		}
	}

	@Override
	public String updateAuditDetails(Audit audit) throws CustomException {
		String resString="";
		Audit tempAudit= auditRepo.findById(audit.getAuditId());
		if(tempAudit!=null) {
			auditRepo.save(audit);
			resString="Audit details updated sucessfully";
		}else {
			resString="No matching audit";
		}
		return resString;
	}

	@Override
	public String deleteAuditDetails(int auditId) throws CustomException {
		String resString="";
		Audit tempAudit= auditRepo.findById(auditId);
		if(tempAudit!=null) {
			auditRepo.deleteById(auditId);
			resString="Audit details deleted sucessfully";
		}else {
			resString="No matching audit with the audit Id";
		}
		return resString;
	}



}
