<%-- 
    Document   : VerTiket
    Created on : 2 de jun. de 2023, 10:25:13
    Author     : MariaIlsa
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/formVerTiket.css"/>
    </head>
    <body>
        <header>
            <h1>Veja seu bilhete</h1>
        </header>
        <main>

            <!-- mostrar um bilhete em especifico -->
            <p>Insira os dados usados na compra da passagem:</p>

            <form action="VerTiket" class="container">
                <div id="dados">
                    <div class="item">
                        <label for="id_cpf">CPF</label>
                        <input type="number" name="cpf" id="id_cpf" min="10000000000" max="99999999999" placeholder="digite seu cpf">
                    </div>
                    <div class="item">
                        <!--
                        <label for="id_linha">linha do ônibus</label>
                        <input type="number" name="linha" id="id_linha" required min="001" max="999" placeholder="digite a linha do ônibus" >-->

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
                </div>
                <div class="item" id="divbutton">
                    <input type="submit" value="Ver Bilhete" id="button">
                </div>
            </form>

        </main>
    </body>
</html>
