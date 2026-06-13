
package com.hostel.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.hostel.dao.AllocationDAO;
import com.hostel.dao.RoomDAO;
import com.hostel.dao.StudentDAO;
import com.hostel.model.Allocation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/allocations")
public class AllocationServlet extends HttpServlet {

    AllocationDAO dao =
            new AllocationDAO();

    @Override
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

        StudentDAO studentDAO =
                new StudentDAO();

        RoomDAO roomDAO =
                new RoomDAO();

        String action =
                request.getParameter("action");

        // VACATE ROOM

        if("vacate".equals(action)) {

            int allocationId =
                    Integer.parseInt(
                            request.getParameter("id"));

            dao.vacateRoom(allocationId);

            response.sendRedirect("allocations");

            return;
        }

        // VIEW ALLOCATIONS

        List<Allocation> allocations =
                dao.getAllocationDetails();

        request.setAttribute(
                "students",
                studentDAO.getAllStudents());

        request.setAttribute(
                "rooms",
                roomDAO.getAllRooms());

        request.setAttribute(
                "allocations",
                allocations);

        request.getRequestDispatcher(
                "allocation-list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Allocation allocation =
                new Allocation();

        allocation.setStudentId(
                Integer.parseInt(
                        request.getParameter("studentId")));

        allocation.setRoomId(
                Integer.parseInt(
                        request.getParameter("roomId")));

        allocation.setAllocationDate(
                Date.valueOf(
                        request.getParameter("allocationDate")));

        allocation.setStatus("Active");

        boolean status =
                dao.allocateRoom(allocation);

        if(status) {

            response.sendRedirect(
                    "allocations");

        } else {

            StudentDAO studentDAO =
                    new StudentDAO();

            RoomDAO roomDAO =
                    new RoomDAO();

            request.setAttribute(
                    "students",
                    studentDAO.getAllStudents());

            request.setAttribute(
                    "rooms",
                    roomDAO.getAllRooms());

            request.setAttribute(
                    "error",
                    "Room is Full or Student already has an Active Allocation");

            request.getRequestDispatcher(
                    "allocate-room.jsp")
                    .forward(request, response);
        }
    }
}

