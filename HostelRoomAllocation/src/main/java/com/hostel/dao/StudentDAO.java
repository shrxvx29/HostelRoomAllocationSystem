package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hostel.model.Student;
import com.hostel.util.DBConnection;

public class StudentDAO {

    // Add Student
    public boolean addStudent(Student student) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query ="INSERT INTO students(roll_no,student_name,gender,department,year_of_study,phone,email)VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getDepartment());
            ps.setInt(5, student.getYear());
            ps.setString(6, student.getPhone());
            ps.setString(7, student.getEmail());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get All Students
    public List<Student> getAllStudents() {

        List<Student> students =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Student student =
                        new Student();

                student.setStudentId(
                        rs.getInt("student_id"));

                student.setName(
                        rs.getString("student_name"));

                student.setGender(
                        rs.getString("gender"));

                student.setDepartment(
                        rs.getString("department"));

                student.setYear(
                        rs.getInt("year_of_study"));

                student.setPhone(
                        rs.getString("phone"));

                student.setEmail(
                        rs.getString("email"));

                student.setRollNo(
                        rs.getString("roll_no"));

                students.add(student);
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return students;
    }
    
    public boolean updateStudent(Student student) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "UPDATE students SET roll_no=?, student_name=?, gender=?, department=?, year_of_study=?, phone=?, email=? WHERE student_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getDepartment());
            ps.setInt(5, student.getYear());
            ps.setString(6, student.getPhone());
            ps.setString(7, student.getEmail());
            ps.setInt(8, student.getStudentId());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public boolean deleteStudent(int studentId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "DELETE FROM students WHERE student_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
 // Get Student By Id
    public Student getStudentById(int studentId) {

        Student student = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students WHERE student_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                student = new Student();

                student.setStudentId(
                        rs.getInt("student_id"));

                student.setRollNo(
                        rs.getString("roll_no"));

                student.setName(
                        rs.getString("student_name"));

                student.setGender(
                        rs.getString("gender"));

                student.setDepartment(
                        rs.getString("department"));

                student.setYear(
                        rs.getInt("year_of_study"));

                student.setPhone(
                        rs.getString("phone"));

                student.setEmail(
                        rs.getString("email"));
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return student;
    }
    public List<Student> searchStudents(
            String keyword){

        List<Student> students =
                new ArrayList<>();

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
                    """
                    SELECT *
                    FROM students
                    WHERE student_name LIKE ?
                    OR roll_no LIKE ?
                    """;

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    "%" + keyword + "%");

            ps.setString(2,
                    "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                Student student =
                        new Student();

                student.setStudentId(
                        rs.getInt("student_id"));

                student.setRollNo(
                        rs.getString("roll_no"));

                student.setName(
                        rs.getString("student_name"));

                student.setGender(
                        rs.getString("gender"));

                student.setDepartment(
                        rs.getString("department"));

                student.setYear(
                        rs.getInt("year_of_study"));

                student.setPhone(
                        rs.getString("phone"));

                student.setEmail(
                        rs.getString("email"));

                students.add(student);
            }

            con.close();

        }catch(Exception e){

            e.printStackTrace();
        }

        return students;
    }
}