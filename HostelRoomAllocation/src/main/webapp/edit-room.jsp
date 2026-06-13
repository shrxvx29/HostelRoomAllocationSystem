
<%@ page import="com.hostel.model.Room" %>

<%
Room room =
        (Room) request.getAttribute("room");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Room</title>

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

    width:600px;

    margin:40px auto;

    background:#1a1a1a;

    padding:35px;

    border-radius:20px;
}

h1{
    text-align:center;
    margin-bottom:30px;
}

input,select{

    width:100%;

    padding:12px;

    margin-bottom:15px;

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

a{
    text-decoration:none;
    color:white;
}

</style>
</head>
<body>

<div class="container">

<h1>Edit Room</h1>

<form action="rooms" method="post">

<input type="hidden"
name="action"
value="update">

<input type="hidden"
name="roomId"
value="<%=room.getRoomId()%>">

<input type="text"
name="roomNumber"
value="<%=room.getRoomNumber()%>"
required>

<input type="number"
name="floorNo"
value="<%=room.getFloorNo()%>"
required>

<select name="roomType">

<option value="Single"
<%= room.getRoomType().equals("Single") ? "selected" : "" %>>
Single
</option>

<option value="Double"
<%= room.getRoomType().equals("Double") ? "selected" : "" %>>
Double
</option>

<option value="Triple"
<%= room.getRoomType().equals("Triple") ? "selected" : "" %>>
Triple
</option>

</select>

<input type="number"
name="capacity"
value="<%=room.getCapacity()%>"
required>

<input type="number"
name="occupiedBeds"
value="<%=room.getOccupiedBeds()%>"
required>

<select name="status">

<option value="Available"
<%= room.getStatus().equals("Available") ? "selected" : "" %>>
Available
</option>

<option value="Full"
<%= room.getStatus().equals("Full") ? "selected" : "" %>>
Full
</option>

<option value="Maintenance"
<%= room.getStatus().equals("Maintenance") ? "selected" : "" %>>
Maintenance
</option>

</select>

<button type="submit">

Update Room

</button>

</form>

<br>

<a href="rooms">Back to Rooms</a>

</div>

</body>
</html>

