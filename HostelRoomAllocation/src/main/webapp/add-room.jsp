
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Room</title>

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

<h1>Add Room</h1>

<form action="rooms" method="post">

<input type="text"
name="roomNumber"
placeholder="Room Number"
required>

<input type="number"
name="floorNo"
placeholder="Floor Number"
required>

<select name="roomType">

<option value="Single">Single</option>

<option value="Double">Double</option>

<option value="Triple">Triple</option>

</select>

<input type="number"
name="capacity"
placeholder="Capacity"
required>

<input type="number"
name="occupiedBeds"
value="0"
readonly>

<select name="status">

<option value="Available">
Available
</option>

<option value="Maintenance">
Maintenance
</option>

</select>

<button type="submit">

Add Room

</button>

</form>

<br>

<a href="rooms">Back to Rooms</a>

</div>

</body>
</html>
