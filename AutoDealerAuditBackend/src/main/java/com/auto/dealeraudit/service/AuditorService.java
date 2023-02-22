package com.auto.dealeraudit.service;


import java.util.List;

import com.auto.dealeraudit.dto.AuditorDto;
import com.auto.dealeraudit.entity.Auditor;
import com.auto.dealeraudit.exception.CustomException;

/**
 * @author bharathp
 *
 */
public interface AuditorService {

	public abstract Auditor createAuditor(Auditor auditor) throws CustomException;

	public abstract Auditor getAuditorByid(int auditorId) throws CustomException;

	public abstract List<AuditorDto> getAllAuditors() throws CustomException;
	
	public abstract List<Auditor> updateAuditorsAudits(List<Auditor> auditors) throws CustomException ;

}
