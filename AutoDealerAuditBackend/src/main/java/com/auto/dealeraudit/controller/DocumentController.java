package com.auto.dealeraudit.controller;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.auto.dealeraudit.dto.Country;
import com.auto.dealeraudit.dto.DocumentDocDto;
import com.auto.dealeraudit.dto.DocumentDto;
import com.auto.dealeraudit.dto.MultipleDocEditDto;
import com.auto.dealeraudit.dto.Section;
import com.auto.dealeraudit.entity.Document;
import com.auto.dealeraudit.entity.User;
import com.auto.dealeraudit.exception.CustomException;
import com.auto.dealeraudit.repository.CountryRepository;
import com.auto.dealeraudit.repository.SectionRepository;
import com.auto.dealeraudit.service.DocumentService;
import com.auto.dealeraudit.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("stgit.com/autodealerauditappapi/document/v1")
public class DocumentController {

	@Autowired
	DocumentService documentService;
	@Autowired
	UserService userService;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	SectionRepository sectionRepository;

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	@PostMapping(value="/document", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Document> createDocument2(@RequestBody Document document) {
		return ResponseEntity.status(HttpStatus.CREATED).body(documentService.createDocument2(document));
	}

	/*
	 * @PostMapping(value = "/createDocument", consumes = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	 * 
	 * public ResponseEntity<Document> createUser( @RequestPart String dto1
	 * ,@RequestPart MultipartFile file) throws CustomException, IOException {
	 * 
	 * DocumentDto dto = new DocumentDto(); try { ObjectMapper objectMapper = new
	 * ObjectMapper(); dto = objectMapper.readValue(dto1, DocumentDto.class); }
	 * catch (IOException err) { System.out.printf("Error", err.toString()); }
	 * 
	 * 
	 * User user = userService.readUserById(dto.getUserId()); Document document =
	 * new Document (dto.getId(),dto.getCountry(),dto.getYear(),
	 * dto.getProgramCode() , dto.getResourceType() , dto.getDocumentTitle() ,
	 * dto.getCategory() , file.getBytes() , dto.getRevisionDate(),
	 * dto.getRevisionStatus() , dto.getDocumentStatus() , dto.getSection(),
	 * dto.getDescription() ,user);
	 * 
	 * return new ResponseEntity<Document>(documentService.createDocument(document),
	 * HttpStatus.ACCEPTED);
	 * 
	 * }
	 */

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getDocumentById/{documentId}")
	public ResponseEntity<Document> getDocumentById(@Valid @PathVariable("documentId") int documentId) {
		return new ResponseEntity<Document>(documentService.readDocumentById(documentId), HttpStatus.OK);
	}

	
	@GetMapping(value = "/getAllDocuments")
	public ResponseEntity<List<Document>> getAllDocuments() {
		return new ResponseEntity<List<Document>>(documentService.readAllDocuments(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getFilteredDocuments")
    public void filters(@RequestParam MultiValueMap<String, String> filters) {
        System.out.println("Filters:");
        filters.get("filter").forEach(System.out::println);
    }
	
	@PostMapping(value="/getFilteredDocs",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Document>> filteredDocs(@RequestBody DocumentDto filters) {
		return new ResponseEntity<List<Document>>(documentService.filteredDocuments(filters), HttpStatus.OK);
    }
	
	@GetMapping(value = "/readDocInDocument")
	public ResponseEntity<String>  readDocInDocument(@RequestParam int id){
		return ResponseEntity.status(HttpStatus.OK).body(documentService.readDocInDocument(id));
	}
	
	@GetMapping(value = "/getAllDocumentswoDocs")
	public ResponseEntity<List<DocumentDocDto>> readDocumentWODoc(){
		return ResponseEntity.status(HttpStatus.OK).body(documentService.readDocumentWODoc());
		
	}
	
	@RequestMapping(value="/requestotp",method = RequestMethod.POST) 
	public ResponseEntity<List<Document>> requestOTP( @RequestBody Map<String,DocumentDto> params) 
	{
	DocumentDto dto = params.get("dto");
	return new ResponseEntity<List<Document>>(documentService.filteredDocuments(dto), HttpStatus.OK);

	}

	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	@DeleteMapping(value = "/deleteDocument/{documentId}/{userPassword}")
	public ResponseEntity<String> deleteDocument(@Valid @PathVariable("documentId") int documentId) {
		return new ResponseEntity<String>(documentService.deleteById(documentId), HttpStatus.OK);
	}

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */
	
	
	/*
	 * @PutMapping(value = "/updateDocument/{document}") public
	 * ResponseEntity<Document> updateDocument(@Valid @RequestBody Document
	 * document) { return new
	 * ResponseEntity<Document>(documentService.updateDocument(document),
	 * HttpStatus.ACCEPTED);
	 * 
	 * }
	 */
	 

	@PutMapping(value = "/updateSelectedDocument/{multipleDocEditDto}")
	public ResponseEntity<String> updateSelectedDocument(@Valid @RequestBody MultipleDocEditDto multipleDocEditDto) {
		return new ResponseEntity<String>(documentService.updateSelectedDocument(multipleDocEditDto), HttpStatus.ACCEPTED);

	}
	
	//---------------------------------doc ref controllers
	@GetMapping(value="/countries")
	public ResponseEntity<List<Country>> getAllCountries(){
		return new ResponseEntity<List<Country>>(countryRepository.findAll(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/sections")
	public ResponseEntity<List<Section>> getAllSections(){
		return new ResponseEntity<List<Section>>(sectionRepository.findAll(),HttpStatus.ACCEPTED);
	}
}
