<%-- 
    Document   : VerDestinos
    Created on : 2 de jun. de 2023, 10:25:49
    Author     : MariaIlsa
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/verDestinos.css">
    </head>
    <body>
        <header>
            <h1>Confira nossos destinos</h1>
        </header>
        <table>
            <thead>

            <th scope="col">Linha</th>
            <th scope="col">Destino</th>
            <th scope="col">Origem</th>
            <th scope="col">Data</th>
            <th scope="col">Preço</th>


        </thead>
        <tbody>
            <!-- loop java para mostrar todos os tikets -->
            <!-- loop java para mostar conteúdo das linhas -->
            <%
                List<Classes.Viagem> bilhetesCadastrados = (List<Classes.Viagem>) request.getAttribute("viagensCadastradas");
            %>
            <% for (Classes.Viagem bilhete : bilhetesCadastrados) {%>
            <tr>
                <td><%out.print(bilhete.getLinha());%></td>
                <td><%out.print(bilhete.getDestino());%></td>
                <td><%out.print(bilhete.getOrigem());%></td>
                <td><%out.print(bilhete.getData());%></td>
                <td><%out.print(bilhete.getPreco());%></td>

            </tr>
            <%}%>
        </tbody>

    </table>
    <a href="index.html">
        <button id="button">Home</button>
    </a>
</body>
</html>
