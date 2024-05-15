<%-- 
    Document   : detalle
    Created on : 13 may 2024, 20:22:56
    Author     : sergio
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="formateador" class="util.FormateadorDecimal" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle</title>
    </head>
    <style>
        .centered {
            text-align: center;
        }
        img{
            display: block;
            margin: 0 auto; /* Centrar la imagen horizontalmente */
            border: 2px solid transparent; /* Añade un borde transparente por defecto */
            transition: border-color 0.3s; /* Transición suave para el cambio de color del borde */
        }
        img:hover {
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
        <h1>Detalle del pedido</h1>
        <br>
        <table border="1">
            <tr>
                <th class="col-usuario">Usuario</th>
                <th class="col-importe">Importe</th>
            </tr>
            <tr>
                <td class="usuario-pedido">${usuario.correoElectronico}</td>
                <td class="importe-pedido">${formateador.darFormato(pedido.importe)}</td>
            </tr>
        </table>
    </center>
    <div class="centered">
        <hr class="short-hr">
        <form action="SvDetalle" method="post">
            <button type="submit" name="accion" value="volver" style="border: none; background: none; padding: 0; margin: 0; cursor: pointer;">
                <img src="./imagenes/musica.gif" alt="Volver a la página principal">
            </button>
            <br>
            Volver a la página principal
        </form>
        <hr class="short-hr">
    </div>
</html>
