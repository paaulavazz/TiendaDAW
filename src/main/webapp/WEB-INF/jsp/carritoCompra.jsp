<%-- 
    Document   : carritoCompra
    Created on : 15-abr-2024, 11:23:58
    Author     : Paula Vázquez Tella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Carrito de la compra</title>
  <meta charset="UTF-8">
</head>
<body bgcolor="#FDF5E6">
  <h1>Carrito de la compra</h1>
  <table border="1">
    <tr>
      <th>TITULO DEL CD</th>
      <th>Cantidad</th>
      <th>Importe</th>
    </tr>
    <!-- Aquí se agregarán las filas con los CDs seleccionados -->
  </table>
  <br>
  <table border="1">
    <tr>
      <td colspan="3">IMPORTE TOTAL</td>
    </tr>
    <!-- Aquí se agregará la fila con el importe total -->
  </table>
  <hr>
  <div>
    <a href="index.html"><img src="./imagenes/sigo_comprando.png" alt="Sigo comprando"></a>
    <a href="Caja.jsp"><img src="./imagenes/me_largo_a_pagar.png" alt="Me largo a pagar"></a>
  </div>
  <hr>
</body>
</html>

