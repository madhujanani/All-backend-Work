package com.springbootproject.ELearningPortal.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "User1")           
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")           	           	
	private int userId;
	private String name;
	private  String email;
	private long phoneNo;
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "contact")
	User1 user;

}