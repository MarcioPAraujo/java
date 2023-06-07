<%-- 
    Document   : AtualizarPassagem
    Created on : 2 de jun. de 2023, 10:26:22
    Author     : MariaIlsa
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/atualizarPassagem.css">
    </head>
    <body>
        <header>

        </header>
        <main>
            <div>
                <form action="AtualizarPassagem" class="container">
                    <fieldset class="dados">
                        <h2>Quem é você e para onde vai?</h2>
                        <div>
                            <label for = "id_passageiro">CPF</label>
                            <input type = "number" name ="cpf"id = "id_passageiro" placeholder= "Digite o cpf" min="10000000000" max="99999999999"> 
                        </div>
                        <div>
                            <!--
                            <label for = "id_linha">linha do ônibus</label>
                            <input type = "text" name ="linha"id = "id_linha" placeholder= "Digite a linha" minlength="3" maxlength="3"> -->

                            <%
                                List<Classes.Viagem> ViagemCadastradas = (List<Classes.Viagem>) request.getAttribute("listaviagem");
                            %>
                            <label for="id_linha">linha do ônibus</label>
                            <select name="linha" id="id_linha">
                                <!-- java loop para mostar as linhas -->

                                <%for (Classes.Viagem v : ViagemCadastradas) {%>
                                <option value=<%out.print(v.getLinha());%>><%out.print(v.getDestino() + " - ");out.print(v.getLinha());%></option>
                                <%}%>

                            </select>

                        </div>
                    </fieldset>
                                <fieldset class="dados">
                        <h2>Atualize os dados da passagem</h2>
                        <div>
                            <label for = "id_assento">
                                Escolha o Assento
                            </label>
                            <input type = "number" name ="assento" id = "id_assento" placeholder= "" min="1" max="45"> 
                        </div>
                        <div>
                            <label for = "id_fila">
                                Fila
                            </label>
                            <input type = "text" name ="fila"id = "id_fila" placeholder= "ex: 'A'" minlength="1" maxlength="1"> 
                        </div>
                        <div>
                            <label for = "id_plataforma">
                                Plataforma
                            </label>
                            <input type = "number" name ="plataforma" id = "id_plataforma" placeholder= "ex: '123'" min="1" max="100"> 
                        </div>
                        <div>
                            <label for = "id_prefixo">
                                Prefixo
                            </label>
                            <input type = "text" name ="prefixo"id = "id_prefixo" placeholder= "ex: 'A12'" minlength="3" maxlength="3"> 
                        </div>
                    </fieldset>
                    <div>
                        <input type ="submit" value ="Atualizar" id="button">
                    </div>
                </form>

            </div>
        </main>
    </body>
</html>
