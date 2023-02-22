package com.auto.dealeraudit.entity;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "document")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@NotEmpty(message = "Required Country")
	@Size(max = 50, message = "Country name should be less than 50")
	@Column(name = "country", nullable = false, length = 50)
	private String country;

	@NotNull(message = "Required year ")
	@Column(name = "year", nullable = false, length = 4)
	private int year;

	@NotEmpty(message = "Program Code Required")
	@Size(max = 10, message = "Program Code can not have more than 10 characters")
	@Column(name = "programCode", length = 10)
	private String programCode;

	public enum ResourceType {
		RSA, SALES, WARRANTY
	}

	@NotNull(message = "Choose Resource Type")
	@Column(name = "resourceType")
	private ResourceType resourceType;

	@NotEmpty(message = "Document Title Required")
	@Size(max = 150, message = "Document Title can not have more than 150 characters")
	@Column(name = "documentTitle", nullable = false, length = 150)
	private String documentTitle;

	@NotEmpty(message = "Document Title Required")
	@Size(max = 20, message = "Document Title can not have more than 20 characters")
	@Column(name = "category", nullable = false, length = 20)
	private String category;
	
	@Lob
	@NotEmpty(message = "Document Required , please attach the document")
	@Size(max = 100000000, message = "Document  can be more than  4 MB")
	@Column(name = "document", columnDefinition = "MEDIUMBLOB")
	private String document;

	@Column(name = "revisionDate", nullable = false)
	private LocalDate revisionDate;

	@NotNull(message = "Revision status Required ")
	@Column(name = "revisionStatus", nullable = false)
	private boolean revisionStatus;

	@NotNull(message = "Document status Required ")
	@Column(name = "documentStatus", nullable = false)
	private boolean documentStatus;

	@NotEmpty(message = "Please choose from the Dropdown or enter any")
	@Column(name = "section", nullable = false)
	private String section;

	@Column(name = "description", length = 250)
	private String description;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	@JsonBackReference(value = "userDocument")
	private User user;

	
}
