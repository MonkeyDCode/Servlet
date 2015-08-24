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
public class Fiz extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numA=request.getParameter("num");
        int num=0;
        if(numA!=null)
        {
            try{
            num = Integer.valueOf(numA);
            }catch(Exception e){}
        }

        try {
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
            out.println("<div class=\"col-md-6\">");
            out.println("<form id=\"formulario\"");
            out.println("<p>");
            out.println("<label for=\"name\">Numero (Obligatorio)</label>\n" +
"                <input type=\"text\" name=\"num\" id=\"name\" placeholder=\"0  \" autofocus >");
            out.println("</p>");
            out.println("<input type = \"submit\" value=\"Enviar\">");
            
            
            out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<h1>Servlet Form at " + request.getContextPath() + "</h1>");
            
            if(num>0)
            {
                 out.println("<p>");
                for(int i =1;i<=num;i++)
                {
                    if(i%3==0 && i%5==0)
                    {
                        out.println(i+" Buzz <br>");
                    }
                    else
                    {
                        if(i%5==0)
                        {
                            out.println(i+" Bazz <br>");
                        }
                        else
                        {
                            if(i%3==0)
                            {
                               out.println(i+" Fizz <br>");
                            }
                            else
                            {
                                out.println(i+" <br>");
                            }
                        }
                    }
                }
                 out.println("</p>");
            }
            else
            {
                out.write("<h3>El número debe ser mayor de 0</h3>");
            }
            
            out.println("</div>");
            out.println("</div>");
            
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
