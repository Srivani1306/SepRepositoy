package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CourseRegistrationDaoImpl implements CourseRegistrationDao{

	private static Connection con = null; 
	private PreparedStatement pstmt= null,pstmt1=null,pstmt2=null;
	private ResultSet rs = null,rs1 = null;
	private Statement st = null,st1=null;
	
	//static block
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		} catch (Exception e) {
			System.out.println("Error Occurred While getting Connection From JNDI!!!!!");
		}
	}
	
	@Override
	public String createCourseRegistration(Registration registration) {
		Date d = new Date();
		String insertStatus = "Failure";
		try {
			if (con != null) {
				pstmt = con.prepareStatement("insert into naresh_course_registration values(?,?,?,?,?,?,?,?,?,?)");
				pstmt.setInt(1, getSequenceValueForCourseRegistration());
				pstmt.setString(2, registration.getFullName());
				pstmt.setString(3, registration.getEmailId());
				pstmt.setString(4, registration.getContactNo());
				pstmt.setString(5, registration.getCourse());
				pstmt.setString(6, registration.getTrainingMode());
				pstmt.setDate(7, new java.sql.Date(d.getTime()));
				pstmt.setString(8, registration.getCreatedBy());
				pstmt.setDate(9, new java.sql.Date(d.getTime()));
				pstmt.setString(10, registration.getUpdatedBy());
				int insertedCount = pstmt.executeUpdate();
				insertStatus =  insertedCount > 0 ? "Row Inserted Successfully" : "Record Not Inserted Due to Some Error";

			} else {
				System.out.println("Database Connection Problem!!!!");
			}
		} catch (SQLException e) {
			System.out.println("Problem Occurred During inserting record in createCourseRegistration()...");
		}
		return insertStatus;
	}
 
	@Override
	public List<Registration> getAllCourseRegistration() {
		List<Registration> registrationList = new ArrayList<Registration>();
		try {
			if(con != null) {
				st1 = con.createStatement();
				ResultSet rs = st1.executeQuery("select * from naresh_course_registration");
				while(rs.next()) {
					Registration reg = new Registration();
					reg.setregistrationSeqId(rs.getLong(1));
					reg.setFullName(rs.getString(2));
					reg.setEmailId(rs.getString(3));
					reg.setContactNo(rs.getString(4));
					reg.setCourse(rs.getString(5));
					reg.setTrainingMode(rs.getString(6));
					//adding the reg object to RegistrationList
					registrationList.add(reg);
				}
			}else {
				System.out.println("Database Connection Problem!!!!");
			}
		} catch (SQLException e) {
			System.out.println("Problem Occurred During the execution of getAllCourseRegistration().....");
		}
		return registrationList;
		
	}
	
	@Override
	public int getSequenceValueForCourseRegistration() {
		int sequenceValue = 0;
		try {
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery("select course_registration_seq.nextval from dual");
				rs.next();
				sequenceValue = rs.getInt(1);
			} else {
				System.out.println("Database Connection Problem!!!!");
			}
		} catch (SQLException e) {
			System.out.println("Problem Occurred During execution of getSequenceValueForCourseRegistration()....");
		}
		return sequenceValue;
	}
	
	@Override
	public boolean deleteRegistration(String regSeqId) {
		int deleteCount = 0;
		try {
			if(con != null) {
				pstmt1 = con.prepareStatement("delete from naresh_course_registration where course_registration_seq_id = ?");
				pstmt1.setString(1, regSeqId);			
				deleteCount = pstmt1.executeUpdate();
			}else {
				System.out.println("Database Connection Problem");
			}
		} catch (SQLException e) {
			System.out.println("Problem Occurred During the execution of deleteRegistration().....");
		}
		return deleteCount > 0 ;
	}
	
	@Override
	public Registration getCourseRegistration(String regSeqId) {
		Registration registration = null; 
		try {
			if(con != null) {
				pstmt2 = con.prepareStatement("select * from naresh_course_registration where course_registration_seq_id =?");
				pstmt2.setString(1, regSeqId);
				rs1 = pstmt2.executeQuery();
				if(rs1.next()) {
					registration = new Registration();
				    registration.setregistrationSeqId(rs1.getLong(1));
					registration.setFullName(rs1.getString(2));
					registration.setEmailId(rs1.getString(3));
					registration.setContactNo(rs1.getString(4));
					registration.setCourse(rs1.getString(5));
					registration.setTrainingMode(rs1.getString(6));
				}				
			}else {
				System.out.println("Database Connection Problem");
			}
		} catch (SQLException e) {
			System.out.println("Problem Occured During the execution of getCourseRegistration().....");
		}
		return registration;
	}


}	