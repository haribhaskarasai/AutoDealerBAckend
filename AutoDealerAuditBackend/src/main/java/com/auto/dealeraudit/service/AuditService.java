package com.auto.dealeraudit.service;



import java.util.List;

import com.auto.dealeraudit.entity.Audit;
import com.auto.dealeraudit.exception.CustomException;

/**
 * @author bharathp
 *
 */
public interface AuditService {
	
	public abstract Audit createAudit(Audit audit) throws CustomException;
	
	public abstract Audit getAuditDetails(int auditId) throws CustomException;
	
	public abstract List<Audit> getAllAuditDetails() throws CustomException;
	
	public abstract String updateAuditDetails(Audit audit) throws CustomException;
	
	public abstract String deleteAuditDetails(int auditId) throws CustomException;

}
