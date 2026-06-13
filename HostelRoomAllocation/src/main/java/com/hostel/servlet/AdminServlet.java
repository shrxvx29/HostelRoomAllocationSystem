package com.hostel.servlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.hostel.dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    	
    	

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO dao = new AdminDAO();

        if(dao.login(username,password)) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "admin",
                    username);

            response.sendRedirect(
                    "dashboard");
        } else {

            response.setContentType("text/html");

            response.getWriter().println(
                    "<h2 style='color:red'>Login Failed</h2>");
        }
        
        HttpSession session =
                request.getSession();

        session.setAttribute(
                "admin",
                username);
    }
}