package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.RequestDao;
import com.model.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			RequestDao requestDao = new RequestDao();
			
			List<Request> activeRequests = requestDao.getAllActiveRequests();
			request.setAttribute("activeRequests", activeRequests);
			
			List<Request> archiveRequests =  requestDao.getAllArchiveRequests();
			request.setAttribute("archiveRequests", archiveRequests);
			
			request.getRequestDispatcher("./dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		boolean isUpdated = new RequestDao().updateRequest(id, status);

		if (isUpdated) {
			request.setAttribute("status", "Data Updated Successfully");
		} else {
			request.setAttribute("status", "Data not Updated");
		}

		response.sendRedirect("./dashboard.jsp");
	}
}
