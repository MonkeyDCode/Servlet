/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uaemex.fi.diseno.agosto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarioAlberto
 */
public class Headers extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            Enumeration<String> nombres = request.getHeaderNames();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Headers</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Headers at " + request.getContextPath() + "</h1>");
            out.println("<h2>Los especiales</h2>");
            out.println("<p><b> Tipo (metodo) de petición: </b>"+request.getMethod()+"</p>");
            out.println("<p><b>URI: </b>"+request.getRequestURI()+"</p>");
            out.println("<p><b>Protocolo : </b>"+request.getProtocol()+"</p>");
            out.println("<h2>La plebe :v</h2>");
            out.println("<table border = \"1\">");
            out.println("<tr bgcolor = \"#AAA\">");
            out.println("<td>Encabezado </td>");
            out.println("<td>Valor</td>");
            out.println("</tr>");
            while(nombres.hasMoreElements())
            {
                String nom = nombres.nextElement();
                out.println("<tr>");
                out.println("<td>"+nom+"</td>");
                out.println("<td>"+request.getHeader(nom)+"</td>");
                out.println("</tr>");
            }   
            out.println("</table>");
            out.println("");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
