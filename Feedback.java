package com.springbootproject.ELearningPortal.entity;

import java.util.Date;

import org.hibernate.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
	
	
	private int userId;
	
	@Column(length=100)
	private String name;

	@Column(length = 100)
	private  String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fId;
	
	@Column(length = 100)
	private  String feedback;
	
	@ManyToOne
	private User1 user;
	
	
	
	
}