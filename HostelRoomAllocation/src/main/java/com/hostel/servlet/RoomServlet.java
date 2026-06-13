package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.RoomDAO;
import com.hostel.model.Room;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/rooms")
public class RoomServlet extends HttpServlet {

    RoomDAO dao = new RoomDAO();

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

        String action =
                request.getParameter("action");

        // DELETE ROOM
        if("delete".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id"));

            dao.deleteRoom(id);

            response.sendRedirect("rooms");
            return;
        }

        // EDIT ROOM
        if("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id"));

            Room room =
                    dao.getRoomById(id);

            request.setAttribute(
                    "room",
                    room);

            request.getRequestDispatcher(
                    "edit-room.jsp")
                    .forward(request, response);

            return;
        }

        // VIEW ROOMS
        List<Room> rooms =
                dao.getAllRooms();

        request.setAttribute(
                "rooms",
                rooms);

        request.getRequestDispatcher(
                "room-list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        // UPDATE ROOM
        if("update".equals(action)) {

            Room room = new Room();

            room.setRoomId(
                    Integer.parseInt(
                            request.getParameter("roomId")));

            room.setRoomNumber(
                    request.getParameter("roomNumber"));

            room.setFloorNo(
                    Integer.parseInt(
                            request.getParameter("floorNo")));

            room.setRoomType(
                    request.getParameter("roomType"));

            room.setCapacity(
                    Integer.parseInt(
                            request.getParameter("capacity")));

            room.setOccupiedBeds(
                    Integer.parseInt(
                            request.getParameter("occupiedBeds")));

            room.setStatus(
                    request.getParameter("status"));

            dao.updateRoom(room);

            response.sendRedirect("rooms");
            return;
        }

        // ADD ROOM
        Room room = new Room();

        room.setRoomNumber(
                request.getParameter("roomNumber"));

        room.setFloorNo(
                Integer.parseInt(
                        request.getParameter("floorNo")));

        room.setRoomType(
                request.getParameter("roomType"));

        room.setCapacity(
                Integer.parseInt(
                        request.getParameter("capacity")));

        room.setOccupiedBeds(
                Integer.parseInt(
                        request.getParameter("occupiedBeds")));

        room.setStatus(
                request.getParameter("status"));

        dao.addRoom(room);

        response.sendRedirect("rooms");
    }
}

