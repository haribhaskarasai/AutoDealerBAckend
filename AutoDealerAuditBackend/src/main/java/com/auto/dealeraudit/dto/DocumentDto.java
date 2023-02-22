package com.auto.dealeraudit.dto;

import java.time.LocalDate;
import com.auto.dealeraudit.entity.Document.ResourceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentDto {

	private int id;

	private String country;

	private Integer year;

	private String programCode;

	private ResourceType resourceType;

	private String documentTitle;

	private String category;

	private LocalDate revisionDate;

	private Boolean revisionStatus;

	private Boolean documentStatus;

	private String section;

	private String description;

	private int userId;

}
