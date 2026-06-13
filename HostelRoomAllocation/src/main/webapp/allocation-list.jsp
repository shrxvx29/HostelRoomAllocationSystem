	
<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Allocation" %>

<%
List<Allocation> allocations =
        (List<Allocation>) request.getAttribute("allocations");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Allocation Management</title>

<style>

body{
    background:#0f0f0f;
    color:white;
    font-family:'Segoe UI';
    padding:30px;
}

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:30px;
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
}

table{
    width:100%;
    border-collapse:collapse;
    background:#171717;
}

th,td{
    padding:15px;
    border:1px solid #2d2d2d;
    text-align:center;
}

th{
    background:#222;
}

.vacate-btn{
    background:#ff4d4d;
    color:white;
    padding:8px 12px;
    border-radius:6px;
    text-decoration:none;
}

</style>
</head>
<body>

<div class="header">

<h1>Allocation Management</h1>

<div class="actions">

<a href="dashboard" class="btn">
Dashboard
</a>

<a href="allocate-room" class="btn">
Allocate Room
</a>

</div>

</div>

<table>

<tr>
<th>ID</th>
<th>Student</th>
<th>Room</th>
<th>Allocation Date</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
if(allocations != null){

for(Allocation a : allocations){
%>

<tr>

<td><%=a.getAllocationId()%></td>

<td><%=a.getStudentName()%></td>

<td><%=a.getRoomNumber()%></td>

<td><%=a.getAllocationDate()%></td>

<td><%=a.getStatus()%></td>

<td>

<%
if("Active".equals(a.getStatus())){
%>

<a href="allocations?action=vacate&id=<%=a.getAllocationId()%>"
class="vacate-btn"
onclick="return confirm('Vacate Room?')">
Vacate
</a>

<%
}
else{
%>

Vacated

<%
}
%>

</td>

</tr>

<%
}
}
%>

</table>

</body>
</html>

