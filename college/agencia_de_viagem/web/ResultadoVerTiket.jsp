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
    </head>
    <body>
        <% Tiket passagem = (Tiket) request.getAttribute("bilhete");%>
        
        <div>
            <div>Assento: <%out.print(passagem.getAssento());%></div>
            <div>Fila: <%out.print(passagem.getFila());%></div>
            <div>Plataforma: <%out.print(passagem.getPlataforma());%></div>
            <div>Prefixo: <%out.print(passagem.getPrefixo());%></div>
            <div>Passageiro: <%out.print(passagem.getPassageiro());%></div>
            <div>Destino: <%out.print(passagem.getViagem());%></div>
            <div>
                <a href="index.html">
                <button>Home</button>
                </a>
            </div>
        </div>
            
    </body>
</html>
