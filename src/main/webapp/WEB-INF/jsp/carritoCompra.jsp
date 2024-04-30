<%@page import="java.util.List"%>
<%@page import="models.CD"%>
<%@page import="java.text.DecimalFormat"%>
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
    .col {
        padding-right: 50px;
    }
    .suma-total {
        text-align: center;
    }
    table {
        background-color: white;
    }
  </style>
</head>
<body bgcolor="#FDF5E6">
    <center>
        <h1>Carrito de la compra</h1>
        <table border="1">
            <tr>
                <th class="titulo-cd">TITULO DEL CD</th>
                <th class="col">Cantidad</th>
                <th class="col">Importe</th>
            </tr>
            <!-- Iterar sobre cada CD en el carrito -->
            <% 
                double total = 0.0; // Variable para almacenar el importe total
                List<CD> carrito = (List<CD>) session.getAttribute("carrito");
                if(carrito != null) {
                    for(CD cd : carrito) {
                        double importe = cd.getPrecio() * cd.getCantidad();
                        total += importe;
            %>
            <tr>
                <td class="titulo-cd"><%= cd.getNombre() %> | <%= cd.getArtista() %> | <%= cd.getPais() %> | $<%= cd.getPrecio() %></td>
                <td class="col"><%= cd.getCantidad() %></td>
                <td class="col"><%= importe %></td>
            </tr>
            <% 
                    }
                }
            %>
        </table>
    
        <br>
        
        <table border="1">
            <tr>
                <th>IMPORTE TOTAL</td>
            </tr>  
            <tr>
                <td colspan="5" class="suma-total"><%= new DecimalFormat("0.00").format(total) %></td>
            </tr>
        </table>
    </center>
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
