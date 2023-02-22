package com.auto.dealeraudit.entity;


import java.time.LocalDateTime;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "permissionId", nullable = false)
	private int permissionId;
	
	@NotEmpty(message = "Required Title")
	@Size(max = 256,message = "Title can not be more than 256 characters")
	@Column(name = "title", nullable = false ,length = 256)
	private String title;
	
	@NotEmpty(message = "Required description")
	@Size(max = 256,message = "Description can not be more than 256 characters")
	@Column(name = "description",length = 256)
	private String description;
	
	@NotNull(message = "Required active status")
	@Column(name = "active", nullable = false )
	private boolean active;
	
	
	@CreationTimestamp
	@Column(name = "createdAt", nullable = false)
	private LocalDateTime createdAt;
	
	
	@UpdateTimestamp
	@Column(name = "updatedAt", nullable = false)
	private LocalDateTime updatedAt;
	
	@NotEmpty(message = "Required the details of the user created this permission")
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@NotEmpty(message = "Required the details of the user updated this permission")
	@Column(name = "updatedBy", nullable = false)
	private String updatedBy;
	
	@JsonManagedReference(value = "permissionToRole")
	@OneToMany(mappedBy = "permission", cascade = CascadeType.MERGE)
	private List<RolePermissions> rolePermissions;

	
}
