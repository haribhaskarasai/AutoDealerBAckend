package com.auto.dealeraudit.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.auto.dealeraudit.dto.DocumentDocDto;
import com.auto.dealeraudit.dto.DocumentDto;
import com.auto.dealeraudit.dto.MultipleDocEditDto;
import com.auto.dealeraudit.entity.Document;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.DocumentRepository;
import com.auto.dealeraudit.service.DocumentService;
import com.auto.dealeraudit.utilities.DocumentSpecifications;


@Service
@Transactional 
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	
	@Override
	public Document createDocument2(Document document) throws CustomException{
		System.out.println(document);
		return documentRepository.save(document);
	}
	
	public Document createDocument(Document document) throws CustomException {
		if (documentRepository.existsById(document.getId())) {
			throw new CustomException("Document already exits");
		}

		return documentRepository.save(document);
	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Document readDocumentById(int id) throws CustomException {
		if (documentRepository.existsById(id)) {
			return documentRepository.findById(id).get();
		} else {
			throw new CustomException("Document does not exits");

		}
	}

	public Document readDocumentTitle(String documentTitle) throws CustomException {
		return null;
	}

	public List<Document> readAllDocuments() throws CustomException {
		if (documentRepository.findAll().isEmpty()) {
			throw new CustomException("There are no documents exits");
		} else {
			return documentRepository.findAll();

		}
	}
	@Override
	public String readDocInDocument(int id) throws CustomException {
		Document document =  documentRepository.findById(id).orElseThrow(() -> new CustomException("document not found"));
		return "\""+document.getDocument()+"\"";
	}
	
	@Override
	public List<DocumentDocDto> readDocumentWODoc() throws CustomException {
		List<Document> documents = documentRepository.findAll();
		List<DocumentDocDto> documentDocDtos = new ArrayList<DocumentDocDto>();
		for(Document document:documents) {
			DocumentDocDto documentDocDto = this.modelMapper.map(document,DocumentDocDto.class);
			documentDocDtos.add(documentDocDto);
		}
		
		return documentDocDtos;
	}
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public Document updateDocument(Document document) throws CustomException {
		if (documentRepository.existsById(document.getId())) {
			return documentRepository.save(document);
		} else {
			throw new CustomException("Document does not exits");

		}
	}

	@Override
	public String updateSelectedDocument(MultipleDocEditDto multipleDocEditDto) throws CustomException {
		
		List<Integer> documentIdsList = multipleDocEditDto.getUpdatingDocsumentIdsList();
		for (Integer docId : documentIdsList) {
			Document d = readDocumentById(docId);
			d.setCategory(multipleDocEditDto.getCategory());
			d.setCountry(multipleDocEditDto.getCountry());
			d.setSection(multipleDocEditDto.getSection());
			d.setRevisionStatus(multipleDocEditDto.isRevisionStatus());
			d.setResourceType(multipleDocEditDto.getResourceType());
			d.setYear(multipleDocEditDto.getYear());
			documentRepository.save(d);
		}
		return "All documents updated successfully!!";
	}

	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteById(int id) throws CustomException {
		if (documentRepository.existsById(id)) {
			documentRepository.deleteById(id);
			return "document with " + id + " deleted";

		} else {
			throw new CustomException("Document does not exits");

		}
	}

	@Override
	public List<Document> filteredDocuments(DocumentDto filter) throws CustomException {
		
		Specification<Document> specification = Specification
			    .where(filter.getCountry() == null ? null : DocumentSpecifications.countryNameContains(filter.getCountry()))
			    .and(filter.getCategory() == null ? null : DocumentSpecifications.categoryNameContains(filter.getCategory()))
			    .and(filter.getDescription() == null ? null : DocumentSpecifications.descriptionNameContains(filter.getDescription()))
			    .and(filter.getDocumentStatus()== null ? null : DocumentSpecifications.documentStatus(filter.getDocumentStatus()))
			    .and(filter.getDocumentTitle() == null ? null : DocumentSpecifications.documentTitleContains(filter.getDocumentTitle() ))
			    .and(filter.getProgramCode() == null ? null : DocumentSpecifications.programCodeContains(filter.getProgramCode()))
			    .and(filter.getResourceType() == null ? null : DocumentSpecifications.resourceType(filter.getResourceType()))
			    .and(filter.getRevisionDate() == null ? null : DocumentSpecifications.revisionDate(filter.getRevisionDate()))
			    .and(filter.getRevisionStatus()== null ? null : DocumentSpecifications.documentStatus(filter.getRevisionStatus()))
			    .and(filter.getSection()== null ? null : DocumentSpecifications.sectionContains(filter.getSection()))
			    .and(filter.getYear() == null ? null : DocumentSpecifications.documentYear(filter.getYear()));
			    
			List<Document> characters = documentRepository.findAll(specification);
			
			return characters;
	}

}
