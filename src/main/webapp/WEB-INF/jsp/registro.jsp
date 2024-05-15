<%-- 
    Document   : registro
    Created on : 13 may 2024, 20:23:04
    Author     : sergio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <style>
        .centered {
            text-align: center;
        }
        .image-container {
            display: inline-block;
            margin: 0 10px; /* Espacio entre las imágenes */
        }
        .image-container img,input {
            display: block;
            margin: 0 auto; /* Centrar la imagen horizontalmente */
            border: 2px solid transparent; /* Añade un borde transparente por defecto */
            transition: border-color 0.3s; /* Transición suave para el cambio de color del borde */
        }
        .image-container img:hover {
            border-color: black; /* Cambia el color del borde a negro cuando se pasa el ratón por encima */
        }
        .image-container input:hover {
            border-color: black; /* Cambia el color del borde a negro cuando se pasa el ratón por encima */
        }
        .short-hr {
            width: 50%; /* Ajusta la longitud de la línea horizontal */
        }
        table {
            background-color: white;
        }
    </style>
    <body bgcolor="#FDF5E6">
    <center>
        <h1>No fue posible iniciar sesión, cree un nuevo usuario</h1>
    </center>
    <br>
    <hr class="short-hr">
    <div class="centered">
        <form action="SvLogin" method="post">
            <label for="email">Correo electrónico:</label>
            <input type="email" id="email" name="email"  required>
            <br>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
            <br>
            <label for="tipoTarjeta">Tipo de tarjeta:</label>
            <select id="tipoTarjeta" name="tipoTarjeta" required>
                <option value="">Selecciona un tipo de tarjeta</option>
                <option value="MasterCard">MasterCard</option>
                <option value="VISA">VISA</option>
                <option value="AmericanExpress">American Express</option>
            </select>
            <br>
            <br>
            <label for="numeroTarjeta">Número de tarjeta:</label>
            <input type="number" id="numeroTarjeta" name="numeroTarjeta" required>
            <br>
            <button type="button" onclick="window.history.back();">Cancelar y volver atrás</button>
            <button type="submit">Registrarse y pagar</button>

        </form>

    </div>
    <hr class="short-hr">

</body>
</html>
