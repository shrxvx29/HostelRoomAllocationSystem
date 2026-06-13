
<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Student" %>

<%
List<Student> students =
        (List<Student>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    background:#0f0f0f;
    color:white;
    min-height:100vh;
    padding:30px;
}

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:30px;
}

h1{
    font-size:36px;
}

.actions{
    display:flex;
    gap:15px;
}

.btn{
    background:white;
    color:black;
    padding:12px 20px;
    text-decoration:none;
    border-radius:10px;
    font-weight:bold;
    transition:0.3s;
}

.btn:hover{
    background:#d9d9d9;
}

table{
    width:100%;
    border-collapse:collapse;
    background:#171717;
    border-radius:10px;
    overflow:hidden;
}

th,td{
    padding:15px;
    border:1px solid #2d2d2d;
    text-align:center;
}

th{
    background:#222;
    color:white;
}

tr:hover{
    background:#1f1f1f;
}

.action-btn{
    text-decoration:none;
    padding:8px 12px;
    border-radius:6px;
    font-size:14px;
    font-weight:bold;
    margin:0 4px;
}

.edit-btn{
    background:white;
    color:black;
}

.delete-btn{
    background:#ff4d4d;
    color:white;
}

.no-data{
    text-align:center;
    padding:20px;
}
input{

    padding:10px;

    border-radius:8px;

    border:none;
}

button{

    padding:10px 15px;

    border:none;

    border-radius:8px;

    cursor:pointer;
}

</style>

</head>
<body>

<div class="header">

    <h1>Student Management</h1>

    <div class="actions">

        <a href="dashboard" class="btn">
            Dashboard
        </a>

        <a href="add-student.jsp" class="btn">
            Add Student
        </a>

    </div>

</div>
<form action="students" method="get">

<input
type="text"
name="search"
placeholder="Search Name or Roll No">

<button type="submit">

Search

</button>

</form>

<table>

<tr>
    <th>ID</th>
    <th>Roll No</th>
    <th>Name</th>
    <th>Gender</th>
    <th>Department</th>
    <th>Year</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Actions</th>
</tr>

<%
if(students != null && !students.isEmpty()) {

    for(Student s : students) {
%>

<tr>

    <td><%=s.getStudentId()%></td>

    <td><%=s.getRollNo()%></td>

    <td><%=s.getName()%></td>

    <td><%=s.getGender()%></td>

    <td><%=s.getDepartment()%></td>

    <td><%=s.getYear()%></td>

    <td><%=s.getPhone()%></td>

    <td><%=s.getEmail()%></td>

    <td>

        <a href="students?action=edit&id=<%=s.getStudentId()%>"
           class="action-btn edit-btn">
            Edit
        </a>

        <a href="students?action=delete&id=<%=s.getStudentId()%>"
           class="action-btn delete-btn"
           onclick="return confirm('Are you sure you want to delete this student?')">
            Delete
        </a>

    </td>

</tr>

<%
    }

} else {
%>

<tr>
    <td colspan="9" class="no-data">
        No Students Found
    </td>
</tr>

<%
}
%>

</table>

</body>
</html>

