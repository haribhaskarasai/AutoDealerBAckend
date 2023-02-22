package com.auto.dealeraudit.dto;

import java.util.List;

import com.auto.dealeraudit.entity.Document.ResourceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleDocEditDto {
	private String section;
	private String country;

	private ResourceType resourceType;
	private int year;
	private String category;
	private boolean revisionStatus;
	private List<Integer> UpdatingDocsumentIdsList;
}
