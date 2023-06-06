<%-- 
    Document   : CancelarPassagem
    Created on : 2 de jun. de 2023, 10:27:05
    Author     : MariaIlsa
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>

        </header>
        <main>
            <form action="CancelarPassagem">
                <fieldset>
                    <h2>Sentimos por não querer mais viajar</h2>
                    <div>
                        <label for = "id_passageiro">CPF</label>
                        <input type = "text" name ="cpf"id = "id_passageiro" placeholder= "Digite o cpf" minlength="11" maxlength="11"> 
                    </div>
                    <div>
                        <!--<label for = "id_linha">linha do ônibus</label>
                        <input type = "text" name ="linha"id = "id_linha" placeholder= "Digite a linha" minlength="3" maxlength="3"> -->

                        <%
                            List<Classes.Viagem> ViagemCadastradas = (List<Classes.Viagem>) request.getAttribute("listaviagem");
                        %>
                        <label for="id_linha">linha do ônibus</label>
                        <select name="linha" id="id_linha">
                            <!-- java loop para mostar as linhas -->

                            <%for (Classes.Viagem v : ViagemCadastradas) {%>
                            <option value=<%out.print(v.getLinha());%>><%out.print(v.getDestino() + " - ");
                            out.print(v.getLinha());%> </option>
                            <%}%>

                        </select>

                    </div>
                </fieldset>
                <div>
                    <input type ="submit" value ="Cancelar">
                </div>
            </form>
        </main>
    </body>
</html>
