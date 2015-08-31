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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarioAlberto
 */
public class Hamburguesas extends HttpServlet {
    int ran;
    Random diceRoller = new Random();

    public Hamburguesas() {
        this.ran = generaRandom();
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
    private int generaRandom()
    {
        int t=  diceRoller.nextInt(15) + 1;
        return t;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //String numA="";
        Cookie cook[]=request.getCookies();
        int flag=0;
        for (Cookie ck1 : cook) {
            if(ck1.getName().equals("Cookie"))
                    {
                        ran=Integer.valueOf(ck1.getValue());
                        flag=1;
                    }
        }
        
        //String numA=cook[1].getValue();
        
        String numA=request.getParameter("num");
        //System.out.println(numA);
        int num=0;
        if(numA!=null)
        {
            try{
            num = Integer.valueOf(numA);
            }catch(Exception e){}
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
            out.println("<p>");
            out.println(ran);
            if(num>ran)
            {
                System.out.println(num);
                System.out.println(ran);
                out.println("<h3>Comi menos</h3>");
                 
            }
            else
            {
                if(num <ran)
                    out.write("<h3>comi más</h3>");
                else
                {
                    if(num == ran)
                    {
                        out.write("<h3>Exacto comi "+num+" Hamburguesas</h3>");
                    }
                }
            }
            out.println("<p>");
            
            out.println("</div>");
            out.println("</div>");
            
             out.println("<div class=\"container\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-md-6\">");
            out.println("<form id=\"formulario\"");
            out.println("<p>");
            out.println("<label for=\"num\">Nombre (Obligatorio)</label>\n" +
"                <input type=\"text\" name=\"num\" id=\"num\" placeholder=\"0\" autofocus >");
            out.println("</p>");
            out.println("<input type = \"submit\" value=\"Enviar\">");
            
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
             
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println("Fallo");
        }
            out.close();
        
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
        checaCookie(request,response);
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
        generaRandom();
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

    private void checaCookie(HttpServletRequest request,HttpServletResponse response) {
        Cookie ck[]=request.getCookies();
        int flag=0;
        for (Cookie ck1 : ck) {
            if(ck1.getName().equals("Cookie"))
                    {
                        //ran=Integer.valueOf(ck1.getValue());
                        System.out.println("\n"+ran);
                        flag=1;
                    }
        if(flag==0)
        {
        
            ran=generaRandom();
            Cookie c;  
            c = new Cookie("Cookie",String.valueOf(ran));
            response.addCookie(c);
        }
    }

}
}
