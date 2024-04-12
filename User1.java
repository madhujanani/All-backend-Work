package com.springbootproject.ELearningPortal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@Entity
@Data
@SequenceGenerator(initialValue = 100, name = "userId")
@AllArgsConstructor
public class User1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotBlank(message="Name is required")
	private String name;
	private long phoneNo;
	private  String email;
	private String address;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;
		
	@NotNull(message="password is required")
	private String password;
	private String uploadPhoto;
	private String userType;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="f_id")
//	  private Set<Feedback>feedback = new HashSet<>();
//	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "contact_id")//user_id is the field in the user1 table..//reference==contact table primary key
	private Contact contact;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="feedback_id") //feild name created with this name in feedbacktable
	  private List<Feedback>feedback = new ArrayList<>();
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="user1_course",//new table with this name and contains only primary key of both table.
			joinColumns = {
					@JoinColumn(name="user_id")
			},
			inverseJoinColumns = {
			@JoinColumn(name="course_id")
			}
			)
	List<Course>course =new ArrayList<>();


}
