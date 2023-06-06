<%-- 
    Document   : CadastrarPassageiro
    Created on : 2 de jun. de 2023, 10:16:55
    Author     : MariaIlsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "CadastrarPassageiro">
            <div>
                <label for = "id_nome">
                    nome
                </label>
                <input type = "text" name ="nome"id = "id_nome" placeholder= "Digite nome">
            </div>
            <div>
                <label for ="id_cpf">
                    cpf
                </label>
                <input type ="text" name ="cpf" id ="id_cpf" placeholder="Digite cpf" minlength="11" maxlength="11" >
            </div>
            <div>
                <label for = "id_telefone">
                    telefone
                </label>
                <input type = "text" name ="telefone"id = "id_telefone" placeholder= "Digite telefone">
            </div>
            <div>
                <label for = "id_nascimento">
                    nascimento
                </label>
                <input type = "date" name ="nascimento"id = "id_nascimento" placeholder= "Digite nascimento">
            </div>
            <div>
                <input type="submit" value="Cadastrar" >
            </div>
        </form>
    </body>
</html>
