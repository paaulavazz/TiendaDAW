<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Caja</title>
  <style>
    .centered {
      text-align: center;
    }
    .image-container {
      display: inline-block;
      margin: 0 10px; /* Espacio entre las imágenes */
    }
    .image-container img {
      display: block;
      margin: 0 auto; /* Centrar la imagen horizontalmente */
      border: 2px solid transparent; /* Añade un borde transparente por defecto */
      transition: border-color 0.3s; /* Transición suave para el cambio de color del borde */
    }
    .image-container img:hover {
      border-color: black; /* Cambia el color del borde a negro cuando se pasa el ratón por encima */
    }
    .short-hr {
      width: 50%; /* Ajusta la longitud de la línea horizontal */
    }
    table {
        background-color: white; 
    }
  </style>
</head>
<body bgcolor="#FDF5E6">
    <center>
        <h1>Caja</h1>
        <table border="1">
            <tr>
                <td colspan="3"><b>TOTAL A PAGAR</b></td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center;"><%= new DecimalFormat("0.00").format(request.getAttribute("total")) %></td>
            </tr>
        </table>
    </center>
    <br>
    <hr class="short-hr">
    <div class="centered">
        <div class="image-container">
            <a href="index.html"><img src="./imagenes/musica.gif" alt="Pagar y volver a la página principal"></a>
            <br>
            Pagar y volver a la página principal
        </div>
    </div>
    <hr class="short-hr">
</body>
</html>
