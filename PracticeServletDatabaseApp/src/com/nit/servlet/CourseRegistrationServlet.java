package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dao.CourseRegistrationDao;
import com.nit.dao.CourseRegistrationDaoImpl;
import com.nit.dao.Registration;


public class CourseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside servlet!!!");
		
		System.out.println("Inside Servlet!!!!!!");
		// setting the content type
		response.setContentType("text/html");

		// getting writer object
		PrintWriter pw = response.getWriter();
		
		// creating DAO Class object
				CourseRegistrationDao courseRegDao = new CourseRegistrationDaoImpl();


				String registrationSeqId = request.getParameter("registrationSeqId");
				System.out.println("RegistrationSeqId:::::::" + registrationSeqId);
				
				//Based on RegistrationSeqId value we can find out action either Register button or Delete Hyperlink		
				
				String recordStatus = null;
				if(registrationSeqId  == null) {			
					// collecting the request parameters i.e.,form data
					String RegistrationSeqId = request.getParameter("registrationSeqId");
					String fullName = request.getParameter("fullname");
					String emailId = request.getParameter("emailId");
					String contactNo = request.getParameter("contactNo");
					String courseName = request.getParameter("course");
					String trainingMode = request.getParameter("trainingMode");
			
					// setting the requestParameter values into Registration Object
					Registration reg = new Registration();
					//reg.setregistrationSeqId(registrationSeqId);
					reg.setFullName(fullName);
					reg.setEmailId(emailId);
					reg.setContactNo(contactNo);
					reg.setCourse(courseName);
					reg.setTrainingMode(trainingMode);
					reg.setCreatedBy("Admin");
					reg.setUpdatedBy("User");
					
					// calling the DAO Class object for creating record
					recordStatus = courseRegDao.createCourseRegistration(reg);
				}else {
					boolean deleteFlag = courseRegDao.deleteRegistration(registrationSeqId);
					if(deleteFlag) {
						recordStatus = "Record Deleted Successfully with id:::" + registrationSeqId;
					}		
				}
				
				pw.println("<body bgcolor='cyan'>");
				pw.println("<div style='text-align:center;'>");
				pw.println("<h3 style='color:red;'>Welcome To Naresh IT Technologies!!!!</h3>");
				if (recordStatus != null) {
					
					pw.println("<h4>"+recordStatus+"</h4>");
					
					//collecting all registration informations
					List<Registration> registrationList = courseRegDao.getAllCourseRegistration();
					
					//using for each loop
					pw.println("<table border='2' align='center'>");
					pw.println("<tr>");
					pw.println("<th>S.No</th>"
							+ "<th>registrationSeqId</th>"
							 + "<th>Name</th>"
							 + "<th>EmailID</th>"
							 + "<th>ContactNo</th>"
							 + "<th>Course</th>"
							 + "<th>Training Mode</th>"
							 + "<th>Operations</th>");
					pw.println("</tr>");
				    
					int recordNo = 1;
				    for(Registration registration :registrationList) {
						pw.println("<tr>"
								
								+ "<td>"+recordNo+"</td>"
								+ "<td>"+registration.getRegistrationSeqId()+"</td>"
								+ "<td>"+registration.getFullName()+"</td>"
								+ "<td>"+registration.getEmailId()+"</td>"
								+ "<td>"+registration.getContactNo()+"</td>"
								+ "<td>"+registration.getCourse()+"</td>"
								+ "<td>"+registration.getTrainingMode()+"</td>"
								+ "<td>"
								+ "<a href=CourseRegistrationServlet?registrationSeqId="+registration.getRegistrationSeqId()+">Delete</a>&nbsp;&nbsp;&nbsp;"
								+ "<a href=UpdateCourseRegistrationServlet?registrationSeqId="+registration.getRegistrationSeqId()+">Update</a>"
								+ "</td>"
								+ "</tr>");
						recordNo++;
				    }
					pw.println("</table>");
					pw.println("<div style='text-align:center;'>"
							+ "<a href='index.html'>|Home Page|</a>"
							+ " &nbsp;&nbsp;"
							+ "<a href=DownloadDataPdf>|Download PDF|</a>"
							+ "</div>");
					
				} else {
					pw.println("<h4>Record Not Inserted Due To Some Error!!!!</h4>");
				}
				pw.println("</div>");
				pw.println("</body>");
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

}
