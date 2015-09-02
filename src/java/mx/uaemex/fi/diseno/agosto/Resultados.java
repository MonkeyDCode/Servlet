/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uaemex.fi.diseno.agosto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MarioAlberto
 */
public class Resultados extends HttpServlet {
    private Random diceRoller = new Random();

    private int generaRandom()
    {
        int t=  diceRoller.nextInt(100) + 1;
        return t;
    }
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
        
        int numeroMagico;
            String respuesta;
             HttpSession sesion = request.getSession(true);
             
            Integer val = (Integer)sesion.getAttribute("ganados");
            int ganados= val;
            val = (Integer)sesion.getAttribute("intentos");
            int intentos= val;
            val = (Integer)sesion.getAttribute("intentos");
            int perdidos= val;
        
        
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>How Many Burguers</title>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <meta name=\"author\" content=\"Monkey Dee\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");
            
            
            out.println("<div class=\"container\">");
            out.println("<div class=\"jumbotron\">");
            
            
            out.println("<h1> Ganados : "+ganados+"</h1>");
            
            out.println("<h1> Perdidos : "+perdidos+"</h1>");
            
            out.println("<h1> Intentos : "+intentos+"</h1>");
            numeroMagico= generaRandom();
            sesion.setAttribute("hamburguesas", numeroMagico);
             out.println("<p> <a href=\"Hamburguesas3.html\">Jugar de nuevo</a></p>");
            
            out.println("</div>");
            out.println("</div>");
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
