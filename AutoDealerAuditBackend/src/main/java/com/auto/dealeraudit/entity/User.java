package com.auto.dealeraudit.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", updatable = false, nullable = false)
	private int userId;
	
	@NotEmpty(message = "Mail Required")
	@Email(message = "Not a Valid Email",regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "mailId", nullable = false)
	private String mailId;

	@NotEmpty(message = "First Name Required")
	@Size(max = 34,message = "First Name should not contain more than 34 characters")
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@NotEmpty(message = "Last Name Required")
	@Size(max = 34,message = "Last Name should not contain more than 34 characters")
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@NotEmpty(message = "Password Required")
	@Size(min = 8,max= 16,message = "Password should contain atleast 8 and a max of 16 characters")
	@Column(name = "password", nullable = false)
	private String password;

	@NotEmpty(message = "Middle Initial Required")
	@Column(name = "middleInitial", nullable = false)
	private String middleInitial;

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
	
	@JsonManagedReference(value = "userDocument")
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Document> document;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "roleId",referencedColumnName = "roleId" )
	@JsonBackReference(value = "userRole")
	private Role role;
	
	@JsonManagedReference(value = "userTOAuditor")
    @OneToOne(mappedBy = "user")
	private Auditor auditor;

    @OneToOne(mappedBy = "user")
	private UserAddress userAddress;
	
	
}
