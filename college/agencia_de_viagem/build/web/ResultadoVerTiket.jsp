<%-- 
    Document   : ResultadoVerTiket
    Created on : 4 de jun. de 2023, 15:43:22
    Author     : MariaIlsa
--%>

<%@page import="Classes.Tiket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="verTiketResultado">
    </head>
    <body>
        <% Tiket passagem = (Tiket) request.getAttribute("bilhete");%>

        <div class="container">
            
            <div id="image"></div>
            
            <div id="content_1">
                <div class="item">Assento: <%out.print(passagem.getAssento());%></div>
                <div class="item">Fila: <%out.print(passagem.getFila());%></div>
                <div class="item">Plataforma: <%out.print(passagem.getPlataforma());%></div>
                <div class="item">Prefixo: <%out.print(passagem.getPrefixo());%></div>
                
            </div>
                <div class="item">Passageiro: <%out.print(passagem.getPassageiro());%></div>
                <div class="item">Destino: <%out.print(passagem.getViagem());%></div>
            <div id="content_2">
                
            </div>
        </div>
        <div>
            <a href="index.html">
                <button>Home</button>
            </a>
        </div>

    </body>
</html>
