package com.hostel.servlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.hostel.dao.DashboardDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 HttpSession session =
    	            request.getSession(false);

    	    if(session == null ||
    	       session.getAttribute("admin") == null){

    	        response.sendRedirect(
    	                "login.jsp");

    	        return;
    	    }

        DashboardDAO dao = new DashboardDAO();

        request.setAttribute("studentCount",
                dao.getStudentCount());

        request.setAttribute("roomCount",
                dao.getRoomCount());

        request.setAttribute("availableRooms",
                dao.getAvailableRoomCount());

        request.setAttribute("activeAllocations",
                dao.getActiveAllocationCount());

        request.getRequestDispatcher("dashboard.jsp")
               .forward(request,response);
    }
}