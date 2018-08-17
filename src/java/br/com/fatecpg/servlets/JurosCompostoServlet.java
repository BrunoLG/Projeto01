/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruno
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juros-composto"})
public class JurosCompostoServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Composto - Servlet</title>");
            out.println("<link rel='stylesheet' type='text/css' href='css/pure-min.css'/>");
            out.println("<style>");
            out.println(".grid { display: grid; grid-template-columns: auto auto;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body style=\"padding: 0 15px;\">");
            out.println("<h1>Juros Composto</h1>");
            out.println("<div class='grid'>");
            out.println("<div>");
            out.println("<form class=\"pure-form\" method=get action=juros-composto>");
            out.println("Capital <input type=text name=capital /><br><br>");
            out.println("Taxa (%) <input type=text name=taxa /><br><br>");
            out.println("Tempo (Meses) <input type=text name=tempo /><br><br>");
            out.println("<input class=\"pure-button\" type=submit value=Calcular /> <a class=\"pure-button\" href='home'>Voltar</a></form>");
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(2);
            double capital = Double.parseDouble(request.getParameter("capital")); 
            double taxa = Double.parseDouble(request.getParameter("taxa"))/100;
            double tempo = Double.parseDouble(request.getParameter("tempo"));
            if (capital >= 0 && taxa >= 0 && tempo >= 0){
                out.println("<h3>Montante = R$" + decimalFormat.format((capital * (Math.pow((1 + taxa), tempo)))) + "</h3>");
                out.println("</div>");
                out.println("<div>");
                out.println("<table class=\"pure-table\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Meses</th>");
                out.println("<th>Capital</th>");
                out.println("<th>Juros</th>");
                out.println("<th>Montante</th>");
                out.println("</tr>");
                out.println("</thead>");

                double vlAnterior;
                for (int i = 1; i <= tempo; i++) {
                    vlAnterior = (capital * (Math.pow((1+taxa), i-1)));
                    out.println("<tr>");
                    out.println("<td>" + i + "</td>");
                    out.println("<td>" + decimalFormat.format(vlAnterior) + "</td>");
                    out.println("<td>" + decimalFormat.format(taxa*100) + "% de " + decimalFormat.format(vlAnterior) + " = " + decimalFormat.format((vlAnterior * taxa)) + "</td>");
                    out.println("<td>" + decimalFormat.format((capital * (Math.pow((1 + taxa), i)))) + "</td>");
                    out.println("</tr>");  
                }
                out.println("</table>");
                out.println("</div>");
            }
            out.println("</div>");
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
