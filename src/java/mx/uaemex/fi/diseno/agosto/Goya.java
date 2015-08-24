
package mx.uaemex.fi.diseno.agosto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarioAlberto
 */
public class Goya extends HttpServlet {
    
    private String inicioP;
    private String medioP;
    private String finP;
    private int repeticiones;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        
        this.finP= config.getInitParameter("porra3");
        this.inicioP= config.getInitParameter("porra1");
        this.medioP= config.getInitParameter("porra2");
        //this.repeticiones= Integer.getInteger(config.getInitParameter("repeticiones"));//To change body of generated methods, choose Tools | Templates.
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
        inicioP="gooooya";  
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Goya</title>");
            out.println("<style type=\"text/css\">\n" +
                        "  body {\n" +
                        "    color: blue;\n" +
                        "  </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Goya </h1>");
            
            for(int i =0;i<3;i++)
            {
                out.printf("<p>");
                for(int j =0;j<2;j++)
                    out.printf(inicioP + " ");
                out.println("<br>");
                for(int k =0;k<2;k++)
                {
                    for(int j =0;j<2;j++)
                        out.printf(medioP+ " ");
                    for(int j =0;j<2;j++)
                        out.printf(finP+" ");
                    out.println("<br>");
                }
                
                
                out.printf("</p>");
            }
            
            out.println("<p>"+inicioP+"<p>");
            out.println("<p> U N I V E R S I D A D </p>");
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
