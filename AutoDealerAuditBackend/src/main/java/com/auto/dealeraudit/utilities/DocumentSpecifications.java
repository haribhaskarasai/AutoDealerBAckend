package com.auto.dealeraudit.utilities;



import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.auto.dealeraudit.entity.Document;
import com.auto.dealeraudit.entity.Document.ResourceType;

public final class DocumentSpecifications {

	public static Specification<Document> countryNameContains(String expression) {
		return (root, query, builder) -> builder.like(builder.lower(root.get("country")),"%"+expression.toLowerCase()+"%");
	}

	public static Specification<Document> categoryNameContains(String expression) {
		return (root, query, builder) -> builder.like(builder.lower(root.get("category")),"%"+expression.toLowerCase()+"%");
	}

	public static Specification<Document> descriptionNameContains(String expression) {
		return (root, query, builder) -> builder.like(builder.lower(root.get("description")),"%"+expression.toLowerCase()+"%");
	}

	public static Specification<Document> documentStatus(Boolean bool) {
		return (root, query, builder) -> builder.equal(root.get("documentStatus"), bool);
	}
	
	public static Specification<Document> documentTitleContains(String expression) {
		return (root, query, builder) ->  builder.like(builder.lower(root.get("documentTitle")),"%"+expression.toLowerCase()+"%");
	}
	
	public static Specification<Document> programCodeContains(String expression) {
		return (root, query, builder) ->  builder.like(builder.lower(root.get("programCode")),"%"+expression.toLowerCase()+"%");
	}
	
	public static Specification<Document> revisionDate(LocalDate date) {
		return (root, query, builder) ->  builder.and(builder.lessThanOrEqualTo(root.get("revisionDate"), date));
	}
	
	public static Specification<Document> revisionStatus(Boolean bool) {
		return (root, query, builder) -> builder.equal(root.get("revisionStatus"), bool);
	}
	
	public static Specification<Document> sectionContains(String expression) {
		return (root, query, builder) ->  builder.like(builder.lower(root.get("section")),"%"+expression.toLowerCase()+"%");
	}
	
	public static Specification<Document> documentYear(Integer year) {
		return (root, query, builder) -> builder.equal(root.get("year"), year);
	}
	
	public static Specification<Document> resourceType(ResourceType resType) {
		return (root, query, builder) -> builder.equal(root.get("resourceType"), resType);
	}
	

}
