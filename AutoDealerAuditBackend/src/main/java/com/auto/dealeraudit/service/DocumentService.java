package com.auto.dealeraudit.service;

import java.time.LocalDate;
import java.util.List;

import com.auto.dealeraudit.dto.DocumentDocDto;
import com.auto.dealeraudit.dto.DocumentDto;
import com.auto.dealeraudit.dto.MultipleDocEditDto;
import com.auto.dealeraudit.entity.Document;
import com.auto.dealeraudit.exception.CustomException;




public interface DocumentService {
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	
	public Document createDocument2(Document document) throws CustomException;
	public Document createDocument(Document document) throws CustomException;
/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Document readDocumentById(int id) throws CustomException;
	public Document readDocumentTitle(String documentTitle) throws CustomException;
	public  List<Document>  readAllDocuments() throws CustomException;
	public String readDocInDocument(int id) throws CustomException;
	public List<Document> filteredDocuments(DocumentDto filter) throws CustomException;
	public List<DocumentDocDto> readDocumentWODoc()throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public Document updateDocument(Document document) throws CustomException; // update
	
	public String updateSelectedDocument(MultipleDocEditDto multipleDocEditDto) throws CustomException;
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteById(int id) throws CustomException;
	
}
