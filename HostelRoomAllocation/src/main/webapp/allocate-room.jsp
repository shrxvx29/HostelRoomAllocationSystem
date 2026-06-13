
<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Student" %>
<%@ page import="com.hostel.model.Room" %>

<%
List<Student> students =
(List<Student>)request.getAttribute("students");

List<Room> rooms =
(List<Room>)request.getAttribute("rooms");

String error =
(String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Allocate Room</title>

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
}

.container{

    width:500px;

    margin:50px auto;

    background:#171717;

    padding:30px;

    border-radius:20px;
}

h1{
    text-align:center;
    margin-bottom:25px;
}

label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
}

select,
input{

    width:100%;

    padding:12px;

    margin-bottom:18px;

    border:none;

    border-radius:10px;

    background:#262626;

    color:white;
}

button{

    width:100%;

    padding:14px;

    border:none;

    border-radius:10px;

    background:white;

    color:black;

    font-weight:bold;

    cursor:pointer;
}

button:hover{
    background:#dcdcdc;
}

.back{

    display:block;

    text-align:center;

    margin-top:15px;

    color:white;

    text-decoration:none;
}

.error{

    background:#ff4d4d;

    color:white;

    padding:12px;

    border-radius:10px;

    margin-bottom:15px;

    text-align:center;
}

</style>
</head>
<body>

<div class="container">

<h1>Allocate Room</h1>

<%
if(error != null){
%>

<div class="error">
    <%=error%>
</div>

<%
}
%>

<form action="allocations" method="post">

<label>Student</label>

<select name="studentId" required>

<option value="">
Select Student
</option>

<%
if(students != null){

for(Student s : students){
%>

<option value="<%=s.getStudentId()%>">

<%=s.getName()%>
(
<%=s.getRollNo()%>
)

</option>

<%
}
}
%>

</select>

<label>Room</label>

<select name="roomId" required>

<option value="">
Select Room
</option>

<%
if(rooms != null){

for(Room r : rooms){

if("Available".equals(r.getStatus())){
%>

<option value="<%=r.getRoomId()%>">

<%=r.getRoomNumber()%>
(
<%=r.getRoomType()%>
)

</option>

<%
}
}
}
%>

</select>

<label>Allocation Date</label>

<input
type="date"
name="allocationDate"
required>

<button type="submit">

Allocate Room

</button>

</form>

<a href="allocations" class="back">

Back To Allocations

</a>

</div>

</body>
</html>
