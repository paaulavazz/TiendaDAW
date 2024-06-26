<%-- 
    Document   : caja
    Author     : Paula Vázquez Tella
--%>
<%@page import="models.Carrito"%>
<%@page import="java.util.List"%>
<%@page import="models.CD"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="formateador" class="util.FormateadorDecimal" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Carrito de la compra</title>
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
            .titulo-cd {
                padding-right: 200px;
                text-align: left;
            }
            .col-cantidad {
                padding-right: 70px;
            }
            .col-precio {
                padding-right: 30px;
            }
            .col-radio {
                padding-left: 30px;
                padding-right: 30px;
            }
            .suma-total {
                text-align: center;
            }
            .cantidad-total {
                text-align: left;
            }
            .celda-sin-borde {
                border: none;
            }
            table {
                background-color: white;
            }
        </style>
    </head>
    <body bgcolor="#FDF5E6">
        <form action="/tienda/SvCarritoCompra" method="post"> <!-- Formulario para eliminar CD -->
            <center>
                <h1>Carrito de la compra</h1>
                <table border="1">
                    <tr>
                        <th class="titulo-cd">TITULO DEL CD</th>
                        <th class="col-cantidad">Cantidad</th>
                        <th class="col-precio">Importe</th>
                        <th class="celda-sin-borde"></th>
                    </tr>

                    <c:if test="${not empty carrito}">
                        <c:forEach var="cd" items="${carrito.listaCDs}" varStatus="loop">
                            <tr>
                                <td class="titulo-cd">${cd.nombre} | ${cd.artista} | ${cd.pais} | $${cd.precio}</td>
                                <td class="col-cantidad">${cd.cantidad}</td>
                                <td class="col-precio">${formateador.darFormato(cd.cantidad * cd.precio)}</td>
                                <td class="col-radio">
                                    <input type="radio" name="eliminar" value="${loop.index}"> <!-- Pasando el índice como valor -->
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr>
                        <td colspan="1" class="celda-sin-borde"></td>
                        <td colspan="1" class="suma-total">IMPORTE TOTAL</td>
                        <td colspan="1" class="cantidad-total">${formateador.darFormato(total)}<td>

                        <td colspan="1" align="center">
                    <c:if test="${not empty carrito.listaCDs}">
                        <button type="submit" name="eliminarBtn" value="eliminar">Eliminar</button>
                    </c:if>
                    <c:if test="${empty carrito.listaCDs}">
                        <button type="submit" name="eliminarBtn" value="eliminar" disabled>Eliminar</button>
                    </c:if>

                    </td>
                    </tr>
                </table>
            </center>
        </form>
        <br>
        <hr class="short-hr">
        <div class="centered">
            <div class="image-container">
                <a href="index.html"><img src="./imagenes/sigo_comprando.gif" alt="Sigo comprando"></a>
                <br>
                Sigo comprando
            </div>
            <div class="image-container">
                <a href="/tienda/SvCarritoCompra?accion=pagar"><img src="./imagenes/me_largo_a_pagar.jpg" alt="Me largo a pagar"></a>
                <br>
                Me largo a pagar
            </div>
        </div>
        <hr class="short-hr">
    </body>
</html>
