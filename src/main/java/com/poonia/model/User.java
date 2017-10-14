package com.poonia.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @ApiModelProperty(notes = "The database generated user ID")
	    private Integer id;
	    @ApiModelProperty(notes = "The user name")
	    private String name;
	    @ApiModelProperty(notes = "The user date of birth")
	    private String dateOfBirth;
	    @ApiModelProperty(notes = "The E mail Id of user", required = true)
	    private String emailId;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
}
