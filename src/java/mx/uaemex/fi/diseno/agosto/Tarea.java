/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uaemex.fi.diseno.agosto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarioAlberto
 */
public class Tarea extends HttpServlet {

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
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<title>Tarea</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
            out.println("<meta name=\"author\" content=\"Monkey Dee\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"jumbotron\">");
            out.println("<div class=\"container\">");
            out.println("<h1>Use of the HTML labels</a></h1>");
            out.println("<h4><a href=\"https://github.com/MonkeyDCode/Servlet\">see the code here</a></a></h4>");
            out.println("<br>");
            out.println("<p class=\"lead\"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. "
                    + "Sed sit amet ipsum mauris. Maecenas congue ligula ac quam viverra nec consectetur ante "
                    + "hendrerit. <strong>Donec et mollis dolor.</strong> Praesent et diam eget libero egestas mattis sit "
                    + "amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur. "
                    + "Donec ut libero sed arcu vehicula ultricies a non tortor. Lorem ipsum dolor sit "
                    + "amet, consectetur adipiscing elit. Aenean ut gravida lorem.</p>");
            out.println("</div>");
            out.println("</div>");

            
            out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-md-6\">");
            out.println("<h1>Heading</a></h1>");
            out.println("<h2>Level 2 heading</h2>");
            out.println("<h3>Level 3 heading</h3>");
            out.println("<h4>Level 4 heading</h4>");
            out.println("<h5>Level 5 heading</h5>");
            out.println("<h6>Level 6 heading</h6>");
            out.println("</section>");
            out.println("</div>");
            
           
            out.println("<div class=\"col-md-6\">");
            out.println("<ul class=\"list-group\">");
            out.println("<h1>List</a></h1>");
            out.println("<li class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\"></span>  Item 1</li>");
            out.println("<li class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\"></span>  Item 2</li>");
            out.println("<li class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\"></span>  Item 3</li>");
            out.println("<li class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\"></span>  Item 4</li>");
            out.println("<li class=\"list-group-item\"><span class=\"glyphicon glyphicon-pencil\"></span>  Item 5</li>");
            out.println("</ul>");
            out.println("</div>");
            
            
            out.println("<div class=\"col-md-12\">");
            out.println("<table class=\"table\">");
            out.println("<h1>Table</a></h1>");
            out.println("<tr>");
            out.println("<th>Head 1</th>");
            out.println("<th>Head 2</th>");
            out.println("<th>Head 3</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data 1</td>");
            out.println("<td>Data 2</td>");
            out.println("<td>Data 3</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data 4</td>");
            out.println("<td>Data 5</td>");
            out.println("<td>Data 6</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data 7</td>");
            out.println("<td>Data 8</td>");
            out.println("<td>Data 9</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<hr>");
            out.println("<footer>");
            out.println("<p><a href=\"https://www.facebook.com/Hackberto\"> &copy; MonkeyDeeCode 2015</a></p>");
            out.println("</footer>");
            
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
