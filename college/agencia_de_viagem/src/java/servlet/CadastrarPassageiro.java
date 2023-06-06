
package servlet;

import Classes.Passageiro;
import DAO_Classes.PassageiroDAO;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MariaIlsa
 */
@WebServlet(name = "CadastrarPassageiro", urlPatterns = {"/CadastrarPassageiro"})
public class CadastrarPassageiro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String mensagem = "";
            try {
                PassageiroDAO pdao = new PassageiroDAO();

                Passageiro passageiro = new Passageiro();
                passageiro.setNome(request.getParameter("nome"));
                passageiro.setTelefone(request.getParameter("telefone"));
                passageiro.setCpf(Long.parseLong(request.getParameter("cpf")));
                passageiro.setNascimento(request.getParameter("nascimento"));

                if(pdao.cadastrarPassageiro(passageiro)){
                    mensagem = "Cadasatro realizado com sucesso";
                }else{
                    mensagem = "cadastro não realizado, você já possui um registro no sistema";
                }

            } catch (SQLException ex) {
                ex.getMessage();

            }
            // chamar página de sucesso
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher("Resultado.jsp").forward(request, response);
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
