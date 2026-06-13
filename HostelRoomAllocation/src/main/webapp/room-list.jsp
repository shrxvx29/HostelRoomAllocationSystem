
<%@ page import="java.util.List" %>
<%@ page import="com.hostel.model.Room" %>

<%
List<Room> rooms =
        (List<Room>) request.getAttribute("rooms");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Management</title>

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

</style>

</head>
<body>

<div class="header">

    <h1>Room Management</h1>

    <div class="actions">

        <a href="dashboard" class="btn">
            Dashboard
        </a>

        <a href="add-room.jsp" class="btn">
            Add Room
        </a>

    </div>

</div>

<table>

<tr>
    <th>ID</th>
    <th>Room No</th>
    <th>Floor</th>
    <th>Type</th>
    <th>Capacity</th>
    <th>Occupied Beds</th>
    <th>Status</th>
    <th>Actions</th>
</tr>

<%
if(rooms != null){

for(Room r : rooms){
%>

<tr>

<td><%=r.getRoomId()%></td>
<td><%=r.getRoomNumber()%></td>
<td><%=r.getFloorNo()%></td>
<td><%=r.getRoomType()%></td>
<td><%=r.getCapacity()%></td>
<td><%=r.getOccupiedBeds()%></td>
<td><%=r.getStatus()%></td>

<td>

<a href="rooms?action=edit&id=<%=r.getRoomId()%>"
class="action-btn edit-btn">
Edit
</a>

<a href="rooms?action=delete&id=<%=r.getRoomId()%>"
class="action-btn delete-btn"
onclick="return confirm('Delete Room?')">
Delete
</a>

</td>

</tr>

<%
}
}
%>

</table>

</body>
</html>

