```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hostel Management Login</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:#0f0f0f;
}

.login-container{

    width:400px;

    background:rgba(255,255,255,0.05);

    border:1px solid rgba(255,255,255,0.1);

    backdrop-filter:blur(12px);

    padding:40px;

    border-radius:20px;

    box-shadow:
    0 8px 32px rgba(0,0,0,0.5);

}

.logo{
    text-align:center;
    color:white;
    font-size:28px;
    font-weight:bold;
    margin-bottom:10px;
}

.subtitle{
    text-align:center;
    color:#bdbdbd;
    margin-bottom:30px;
}

.input-group{
    margin-bottom:20px;
}

.input-group input{

    width:100%;

    padding:14px;

    border:none;

    outline:none;

    border-radius:10px;

    background:#1b1b1b;

    color:white;

    font-size:15px;
}

.input-group input::placeholder{
    color:#8f8f8f;
}

.login-btn{

    width:100%;

    padding:14px;

    border:none;

    border-radius:10px;

    background:white;

    color:black;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;

    transition:0.3s;
}

.login-btn:hover{

    background:#dcdcdc;

    transform:translateY(-2px);
}

.forgot{

    margin-top:15px;

    text-align:center;
}

.forgot a{

    color:#bdbdbd;

    text-decoration:none;
}

.forgot a:hover{
    color:white;
}

.footer{

    margin-top:25px;

    text-align:center;

    color:#666;
    font-size:13px;
}

</style>
</head>

<body>

<div class="login-container">

    <div class="logo">
        HOSTEL MANAGEMENT
    </div>

    <div class="subtitle">
        Admin Portal
    </div>

    <form action="login" method="post">

        <div class="input-group">
            <input type="text"
                   name="username"
                   placeholder="Username"
                   required>
        </div>

        <div class="input-group">
            <input type="password"
                   name="password"
                   placeholder="Password"
                   required>
        </div>

        <button class="login-btn"
                type="submit">
            Login
        </button>

    </form>

    <div class="forgot">
        <a href="#">Forgot Password?</a>
    </div>

    <div class="footer">
        Hostel Room Allocation System
    </div>

</div>

</body>
</html>
```
