package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dao.CourseRegistrationDao;
import com.nit.dao.CourseRegistrationDaoImpl;
import com.nit.dao.Registration;

public class UpdateCourseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");				
		PrintWriter pw = response.getWriter();
		String registrationSeqId = request.getParameter("registrationSeqId");
		
		CourseRegistrationDao courseRegistrationDao = new CourseRegistrationDaoImpl();
		Registration registration = courseRegistrationDao.getCourseRegistration(registrationSeqId);
		
		if(registration != null) {	
			pw.println("<body bgcolor='cyan'>");
			pw.println("<h3 style='text-align:center;color:red;'>Welcome To Naresh IT Technologies !!!!!!</h3>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>FullName</td><td><input type='text' name='fullName' value='"+registration.getFullName()+"' readonly/></td>");
			pw.println("<tr><td>Email ID</td><td><input type='email' name='emailId' value='"+registration.getEmailId()+"' readonly/></td>");
			pw.println("<tr><td>Contact No</td><td><input type='text' name='contactNo' value='"+registration.getContactNo()+"'/></td>");
			pw.println("<tr><td>Course</td><td><input type='text' name='courseName' value='"+registration.getCourse()+"'/></td>");
			pw.println("<tr><td>Course</td><td><input type='text' name='trainingMode' value='"+registration.getTrainingMode()+"'/></td>");
			pw.println("<tr><td>&nbsp;</td><td><input type='hidden' name='reqistrationId' value='"+registration.getRegistrationSeqId()+"'/></td>");
			pw.println("<tr><td>&nbsp;</td><td><input type='submit' value ='Update' formAction='UpdateDataCourseServlet' formMethod='post'/></td></tr>");
			pw.println("</table>");
			pw.println("</body>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
