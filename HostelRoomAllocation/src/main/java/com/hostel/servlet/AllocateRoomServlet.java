package com.hostel.servlet;

import java.io.IOException;

import com.hostel.dao.RoomDAO;
import com.hostel.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/allocate-room")
public class AllocateRoomServlet extends HttpServlet {
	

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

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

        request.getRequestDispatcher(
                "allocate-room.jsp")
                .forward(request,response);
    }
}