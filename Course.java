package com.springbootproject.ELearningPortal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@AllArgsConstructor
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String cName;
	private String cDesp;
	private int cFees;
	private String cResource;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "course")
	@JsonIgnore
	private List<User1> employee=new ArrayList<>();
}
