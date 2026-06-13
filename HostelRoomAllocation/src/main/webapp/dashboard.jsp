<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hostel Management Dashboard</title>

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
    font-size:28px;
    font-weight:bold;
}

.logout{
    text-decoration:none;
    background:white;
    color:black;
    padding:10px 20px;
    border-radius:10px;
    font-weight:bold;
}

.container{
    padding:40px;
}

.welcome{
    margin-bottom:35px;
}

.welcome h1{
    font-size:48px;
    margin-bottom:10px;
}

.welcome p{
    color:#bdbdbd;
}

.cards{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
    gap:25px;
}

.card-link{
    text-decoration:none;
    color:white;
}

.card{
    background:#1a1a1a;
    padding:30px;
    border-radius:20px;
    text-align:center;
    transition:0.3s;
    border:1px solid #2e2e2e;
}

.card:hover{
    transform:translateY(-6px);
    border-color:white;
}

.card h3{
    color:#d3d3d3;
    margin-bottom:15px;
}

.count{
    font-size:50px;
    font-weight:bold;
}

.quick-actions{
    margin-top:50px;
}

.quick-actions h2{
    margin-bottom:20px;
}

.menu{
    display:flex;
    gap:20px;
    flex-wrap:wrap;
}

.menu a{
    text-decoration:none;
    background:white;
    color:black;
    padding:15px 25px;
    border-radius:12px;
    font-weight:bold;
    transition:0.3s;
}

.menu a:hover{
    background:#d9d9d9;
}

.footer{
    margin-top:60px;
    text-align:center;
    color:#888;
    font-size:14px;
}

</style>

</head>

<body>

<div class="navbar">

    <div class="logo">
        Hostel Management System
    </div>

    <a href="logout" class="logout">
        Logout
    </a>

</div>

<div class="container">

    <div class="welcome">
        <h1>Admin Dashboard</h1>
        <p>Manage Students, Rooms and Allocations</p>
    </div>

    <div class="cards">

        <a href="students" class="card-link">
            <div class="card">
                <h3>Total Students</h3>
                <div class="count">
                    ${studentCount}
                </div>
            </div>
        </a>

        <a href="rooms" class="card-link">
            <div class="card">
                <h3>Total Rooms</h3>
                <div class="count">
                    ${roomCount}
                </div>
            </div>
        </a>

        <a href="rooms" class="card-link">
            <div class="card">
                <h3>Available Rooms</h3>
                <div class="count">
                    ${availableRooms}
                </div>
            </div>
        </a>

        <a href="allocations" class="card-link">
            <div class="card">
                <h3>Active Allocations</h3>
                <div class="count">
                    ${activeAllocations}
                </div>
            </div>
        </a>

    </div>

    <div class="quick-actions">

        <h2>Quick Actions</h2>

        <div class="menu">

            <a href="students">
                Students
            </a>

            <a href="rooms">
                Rooms
            </a>

            <a href="allocations">
                Allocations
            </a>

            <a href="add-student.jsp">
                Add Student
            </a>

            <a href="add-room.jsp">
                Add Room
            </a>

        </div>

    </div>

    <div class="footer">
        Hostel Room Allocation System © 2026
    </div>

</div>

</body>
</html>