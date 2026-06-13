
package com.hostel.servlet;

import java.io.IOException;
import java.util.List;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Session Check

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("admin") == null) {

            response.sendRedirect(
                    "login.jsp");

            return;
        }

        String action =
                request.getParameter("action");

        // DELETE

        if("delete".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id"));

            dao.deleteStudent(id);

            response.sendRedirect(
                    "students");

            return;
        }

        // EDIT

        if("edit".equals(action)) {

            int id =
                    Integer.parseInt(
                            request.getParameter("id"));

            Student student =
                    dao.getStudentById(id);

            request.setAttribute(
                    "student",
                    student);

            request.getRequestDispatcher(
                    "edit-student.jsp")
                    .forward(request, response);

            return;
        }

        // SEARCH

        String search =
                request.getParameter("search");

        List<Student> students;

        if(search != null &&
           !search.trim().isEmpty()) {

            students =
                    dao.searchStudents(search);

        } else {

            students =
                    dao.getAllStudents();
        }

        request.setAttribute(
                "students",
                students);

        request.getRequestDispatcher(
                "student-list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action =
                request.getParameter("action");

        // UPDATE

        if("update".equals(action)) {

            Student student =
                    new Student();

            student.setStudentId(
                    Integer.parseInt(
                            request.getParameter("studentId")));

            student.setRollNo(
                    request.getParameter("rollNo"));

            student.setName(
                    request.getParameter("name"));

            student.setGender(
                    request.getParameter("gender"));

            student.setDepartment(
                    request.getParameter("department"));

            student.setYear(
                    Integer.parseInt(
                            request.getParameter("year")));

            student.setPhone(
                    request.getParameter("phone"));

            student.setEmail(
                    request.getParameter("email"));

            dao.updateStudent(student);

            response.sendRedirect(
                    "students");

            return;
        }

        // ADD STUDENT

        Student student =
                new Student();

        student.setRollNo(
                request.getParameter("rollNo"));

        student.setName(
                request.getParameter("name"));

        student.setGender(
                request.getParameter("gender"));

        student.setDepartment(
                request.getParameter("department"));

        student.setYear(
                Integer.parseInt(
                        request.getParameter("year")));

        student.setPhone(
                request.getParameter("phone"));

        student.setEmail(
                request.getParameter("email"));

        dao.addStudent(student);

        response.sendRedirect(
                "students");
    }
}

