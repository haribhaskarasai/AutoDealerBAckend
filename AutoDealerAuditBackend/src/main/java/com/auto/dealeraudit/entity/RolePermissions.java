package com.auto.dealeraudit.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "rolePermissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	
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
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleId",referencedColumnName = "roleId" )
	@JsonBackReference(value = "roleToPermission")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "permissionId",referencedColumnName = "permissionId" )
	@JsonBackReference(value = "permissionToRole")
	private Permission permission;

	
}
