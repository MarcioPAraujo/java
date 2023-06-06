<%-- 
    Document   : Resultado
    Created on : 4 de jun. de 2023, 14:00:49
    Author     : MariaIlsa
--%>

<%@page import="Classes.Tiket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <link rel="stylesheet" href="resultados.css"/>
    </head>
    <body>
        <%
            String mensagem = (String) request.getAttribute("mensagem");

        %>
        <main class="container">
            <div class="item" id="text">
                <p><%out.print(mensagem);%></p>
            </div>
            <div class="item">
                <a href="index.html">
                    <button>Home</button>
                </a>
            </div>

        </main>
    </body>
</html>
