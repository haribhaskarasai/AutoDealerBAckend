package com.auto.dealeraudit.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.dto.AuditorDto;
import com.auto.dealeraudit.entity.Auditor;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.AuditorRepository;
import com.auto.dealeraudit.service.AuditorService;



/**
 * @author bharathp
 *
 */
@Service
@Transactional
public class AuditorServiceImpl implements AuditorService {
	
	@Autowired
	private AuditorRepository auditorRepository;
	
	@Override
	public Auditor createAuditor(Auditor auditor) throws CustomException {
		if(auditorRepository.existsById(auditor.getAuditorId())) {
			throw new CustomException("Auditor already exits");
		}
		return auditorRepository.save(auditor);
	}

	@Override
	public Auditor getAuditorByid(int auditorId) throws CustomException {
		if (auditorRepository.existsById(auditorId)) {
			return auditorRepository.findById(auditorId);
		} else {
			throw new CustomException("Auditor does not exits");

		}
	}

	@Override
	public List<AuditorDto> getAllAuditors() throws CustomException { 
		if (auditorRepository.findAll().isEmpty()) {
			throw new CustomException("There are no Auditors exits");
		} else {
			List<Tuple> auditorsTuples =  auditorRepository.findAllAuditors();
			System.out.println(auditorsTuples);
			List<AuditorDto> autorsDto = auditorsTuples.stream().map(t -> new AuditorDto(
					t.get(0, Integer.class), 
                    t.get(1, Integer.class),
                    t.get(2, Integer.class),
                    t.get(3, Integer.class),
                    t.get(4, String.class), 
                    t.get(5, String.class),
                    t.get(6,String.class),
                    t.get(7,String.class),
                    t.get(8,String.class)
					)).collect(Collectors.toList());
			return autorsDto;
		 
	}
}

	@Override
	public List<Auditor> updateAuditorsAudits(List<Auditor> auditors) throws CustomException {
		for (Auditor auditor : auditors) {
			
		}
		return null;
	}
}
