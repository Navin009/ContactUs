package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ContactUsDao;

@SuppressWarnings("serial")
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("./contactus.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		ContactUsDao dao = new ContactUsDao();
		boolean isInserted = dao.insertContactUs(name, email, message);

		HttpSession session = request.getSession();

		if (isInserted) {
			session.setAttribute("status", "Data Submitted!");
			// out.println("<script>alert('Data Submitted!');
			// window.location.replace('./contactus');</script> ");

		} else {
			session.setAttribute("status", "Data Not Submitted!");
			// out.println("<script>alert('Data Not Submitted!');
			// window.location.replace('./contactus')</script> ");
		}
		response.sendRedirect("./contactus");
	}

}
