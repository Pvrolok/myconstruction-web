<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - My Construction</title>
</head>
<body>
    <h2>Iniciar Sesion</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Usuario:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Contrase\u00f1a:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Ingresar</button>
    </form>
</body>
</html>
