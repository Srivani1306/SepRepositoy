package com.nit.dao;

import java.util.List;

public interface CourseRegistrationDao {
    
	//creating the record in CourseRegistration table
		public String createCourseRegistration(Registration registration);
		
		//Retrieve all the records from CourseRegistartion table
		public List<Registration> getAllCourseRegistration();
		
		//getting the sequence value for primary key column for courseRegistration table
		public int getSequenceValueForCourseRegistration();
		
		//deleting the record based on primaryKey
		public boolean deleteRegistration(String regSeqId);
		
		//getting single recored based primaryKey
		public Registration getCourseRegistration(String regSeqId);
}
