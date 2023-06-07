<%-- 
    Document   : CadastrarViagem
    Created on : 2 de jun. de 2023, 10:23:21
    Author     : MariaIlsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/cadastrodapassagem.css">
    </head>
    <body>
        <header>
            <h1>
                Cadastrar novo destino
            </h1>
        </header>
        <main>
            <form action = "CadastrarViagem" class="container">
                <div>
                    <label for = "id_linha">
                        linha do ônibus
                    </label>
                    <input type = "number" name ="linha"id = "id_linha" placeholder= "Digite a linha" min="001" max="999"> 
                </div>
                <div>
                    <label for = "id_destino">
                        destino
                    </label>
                    <input type = "text" name ="destino"id = "id_destino" placeholder= "Digite o destino"> 
                </div>
                <div>
                    <label for = "id_origem">
                        origem
                    </label>
                    <input type = "text" name ="origem"id = "id_origem" placeholder= "Digite a origem"> 
                </div>
                <div>
                    <label for = "id_data">
                        data da viagem
                    </label>
                    <input type = "date" name ="data"id = "id_data" placeholder= "Digite data"> 
                </div>
                <div>
                    <label for = "id_preco">
                        valor
                    </label>
                    <input type = "number" name ="preco"id = "id_preco" placeholder= "Digite o preço" step="1" min="0"> 
                </div>
                <div>
                    <input type ="submit" value ="Cadastrar" id="button">
                </div>
            </form>
        </main>
    </body>
</html>
