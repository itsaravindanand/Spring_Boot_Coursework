<html>
<head>
    <title>Login Page - JSP</title>
</head>
<body>
Welcome to the Login Page!

<form method="post">
    <div class="container">
        <div>Name: <input type = "text" name = "name"></div>
        <div>Password: <input type = "password" name = "password"></div>
        <div><input type = submit></div>
        <div><pre>${errorMessage}</pre></div>
    </div>
</form>
</body>
</html>