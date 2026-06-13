<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<style>

body{
    background:#0f0f0f;
    color:white;
    font-family:Segoe UI;
}

.container{

    width:500px;

    margin:40px auto;

    background:#171717;

    padding:30px;

    border-radius:20px;
}

h1{
    text-align:center;
    margin-bottom:25px;
}

input,select{

    width:100%;

    padding:12px;

    margin-bottom:15px;

    border:none;

    border-radius:10px;

    background:#222;

    color:white;
}

button{

    width:100%;

    padding:12px;

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

</style>

</head>
<body>

<div class="container">

<h1>Add Student</h1>

<form action="students" method="post">

<input
type="text"
name="rollNo"
placeholder="Roll Number"
required>

<input
type="text"
name="name"
placeholder="Student Name"
required>

<select name="gender">

<option>Male</option>

<option>Female</option>

</select>

<input
type="text"
name="department"
placeholder="Department"
required>

<input
type="number"
name="year"
placeholder="Year Of Study"
required>

<input
type="text"
name="phone"
placeholder="Phone Number"
required>

<input
type="email"
name="email"
placeholder="Email"
required>

<button type="submit">

Add Student

</button>

</form>

</div>

</body>
</html>