/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruno
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples"})
public class JurosSimplesServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Juros Simples</title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/pure-min.css'/>");
            out.println("</head>");
            out.println("<body style=\"padding: 0 15px;\">");
            out.println("<h1>Juros Simples</h1>");           
            out.println("<form class=\"pure-form\" method=get action=juros-simples>");
            out.println("Capital <input type=text name=capital /><br><br>");
            out.println("Taxa <input type=text name=taxa /><br><br>");
            out.println("Tempo <input type=text name=tempo /><br><br>");
            out.println("<input class=\"pure-button\" type=submit value=Calcular /> <a class=\"pure-button\" href=home>Voltar</a></form>");
            double capital = Double.parseDouble(request.getParameter("capital")); 
            double taxa = Double.parseDouble(request.getParameter("taxa"));
            double tempo = Double.parseDouble(request.getParameter("tempo"));
            if (capital >= 0 && taxa >= 0 && tempo >= 0){
                out.println("<h3>Juros = R$" + (capital * taxa * tempo) + "</h3>");
            }    
            out.println("</body>");
            out.println("</html>");
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
