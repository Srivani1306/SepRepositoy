package com.nit.dao;

import java.util.Date;

public class Registration {
  
	private Long registrationSeqId;
	private String fullName;
	private String emailId;
	private String contactNo;
	private String course;
	private String trainingMode;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	
	
	
	
	public Registration(Long registrationSeqId, String fullName, String emailId, String contactNo, String course,
			String trainingMode, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
		super();
		this.registrationSeqId = registrationSeqId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.course = course;
		this.trainingMode = trainingMode;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}



	



	public Registration() {
		System.out.println("Regsitration default constructor");
	}







	public Long getRegistrationSeqId() {
		return registrationSeqId;
	}


	public void setregistrationSeqId(long l) {
		this.registrationSeqId = registrationSeqId;
		
	}
	


	public String getFullName() {
		return fullName;
	}




	public void setFullName(String fullName) {
		this.fullName = fullName;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getContactNo() {
		return contactNo;
	}




	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}




	public String getCourse() {
		return course;
	}




	public void setCourse(String course) {
		this.course = course;
	}




	public String getTrainingMode() {
		return trainingMode;
	}




	public void setTrainingMode(String trainingMode) {
		this.trainingMode = trainingMode;
	}




	public Date getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}




	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}




	public Date getUpdatedDate() {
		return updatedDate;
	}




	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}




	public String getUpdatedBy() {
		return updatedBy;
	}




	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}







	
}
