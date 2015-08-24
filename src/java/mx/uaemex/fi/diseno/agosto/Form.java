package mx.uaemex.fi.diseno.agosto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Form extends HttpServlet {

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
        
        String nombre=request.getParameter("name");
        if(nombre==null)
        {
            nombre="";
        }
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("<title>Form</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
            out.println("<meta name=\"author\" content=\"Monkey Dee\">");
            out.println("</head>");
            out.println("<body>");
             out.println("<div class=\"jumbotron\">");
            out.println("<div class=\"container\">");
            out.println("<h1>Servlet Form at " + request.getContextPath() + "</h1>");
            
            if(!nombre.equals(""))
            {
                if(nombre.toLowerCase().equals("hitler")||nombre.toLowerCase().equals("osama")||nombre.toLowerCase().equals("atila"))
                {
                    out.write("<h3>Contigo no hablo :c</h3>");
                }
                else
                {
                    out.write("<h3>Hola "+nombre+"</h3>");
                }
            }
            else
            {
                out.write("<h3>Dime quien eres para saludarte</h3>");
            }
            
            out.println("</div>");
            out.println("</div>");
            
             out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-md-6\">");
            out.println("<form id=\"formulario\"");
            out.println("<p>");
            out.println("<label for=\"name\">Nombre (Obligatorio)</label>\n" +
"                <input type=\"text\" name=\"name\" id=\"name\" placeholder=\"Juan Perez\" autofocus >");
            out.println("</p>");
            out.println("<input type = \"submit\" value=\"Enviar\">");
            
            out.println("</form>");
            out.println("</div>");
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
