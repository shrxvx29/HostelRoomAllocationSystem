```jsp
<%@ page import="com.hostel.model.Student" %>

<%
Student student =
        (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

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
}

.navbar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:20px 40px;
    background:#171717;
    border-bottom:1px solid #2c2c2c;
}

.logo{
    font-size:24px;
    font-weight:bold;
}

.back-btn{
    text-decoration:none;
    background:white;
    color:black;
    padding:10px 20px;
    border-radius:10px;
    font-weight:bold;
}

.container{

    width:600px;

    margin:40px auto;

    background:#1a1a1a;

    padding:35px;

    border-radius:20px;

    border:1px solid #2c2c2c;
}

h1{
    text-align:center;
    margin-bottom:30px;
}

.form-group{
    margin-bottom:18px;
}

label{
    display:block;
    margin-bottom:8px;
    color:#d3d3d3;
}

input,
select{

    width:100%;

    padding:12px;

    border:none;

    border-radius:10px;

    background:#262626;

    color:white;

    font-size:15px;
}

input:focus,
select:focus{
    outline:1px solid white;
}

.btn{

    width:100%;

    padding:14px;

    background:white;

    color:black;

    border:none;

    border-radius:10px;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;

    margin-top:10px;
}

.btn:hover{
    background:#d9d9d9;
}

</style>
</head>

<body>

<div class="navbar">

    <div class="logo">
        Hostel Management System
    </div>

    <a href="students" class="back-btn">
        Back
    </a>

</div>

<div class="container">

    <h1>Edit Student</h1>

    <form action="students" method="post">

        <input type="hidden"
               name="action"
               value="update">

        <input type="hidden"
               name="studentId"
               value="<%=student.getStudentId()%>">

        <div class="form-group">
            <label>Roll Number</label>
            <input type="text"
                   name="rollNo"
                   value="<%=student.getRollNo()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Student Name</label>
            <input type="text"
                   name="name"
                   value="<%=student.getName()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Gender</label>

            <select name="gender">

                <option value="Male"
                <%= student.getGender().equals("Male") ? "selected" : "" %>>
                Male
                </option>

                <option value="Female"
                <%= student.getGender().equals("Female") ? "selected" : "" %>>
                Female
                </option>

            </select>
        </div>

        <div class="form-group">
            <label>Department</label>
            <input type="text"
                   name="department"
                   value="<%=student.getDepartment()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Year Of Study</label>
            <input type="number"
                   name="year"
                   value="<%=student.getYear()%>"
                   min="1"
                   max="4"
                   required>
        </div>

        <div class="form-group">
            <label>Phone Number</label>
            <input type="text"
                   name="phone"
                   value="<%=student.getPhone()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email"
                   name="email"
                   value="<%=student.getEmail()%>"
                   required>
        </div>

        <button type="submit" class="btn">
            Update Student
        </button>

    </form>

</div>

</body>
</html>
```
