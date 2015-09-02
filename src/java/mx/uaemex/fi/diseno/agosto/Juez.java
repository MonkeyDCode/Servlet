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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author MarioAlberto
 */
public class Juez extends HttpServlet {
    protected static final Logger logger = LogManager.getLogger(Juez.class);
    int max =100;
    protected int maximo=100                    ;
    Random diceRoller = new Random();
    private int generaRandom()
    {
        int t=  diceRoller.nextInt(100) + 1;
        return t;
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int numeroMagico;
        String respuesta;
        int ganados;
        HttpSession sesion = request.getSession(true);
        if(sesion.isNew())
        {
            numeroMagico= generaRandom();
            sesion.setAttribute("hamburguesas", numeroMagico);
            sesion.setAttribute("intentos", 0);
            sesion.setAttribute("ganados", 0);
            sesion.setAttribute("perdidos", 0);
        }
        else
        {
            Integer val = (Integer)sesion.getAttribute("hamburguesas");
            numeroMagico= val;
        }
        String cad = request.getParameter("hamburguesas");
        if(cad==null)
        {
            respuesta="Error, revisa los nombres de los camppos";
            
        }
        else
        {
            try
            {
                int recibido = Integer.parseInt(cad);
                if(numeroMagico==recibido)
                {
                    respuesta ="G A N A S T E";
                }
                else if(numeroMagico>recibido)
                        {
                            respuesta="Me subestimas";
                        }
                        else
                        {
                            respuesta = "Tampoco soy tan tragaldabas";
                    
                         }
            }
            catch(NumberFormatException e)
            {
                respuesta = "El valor enviado deberia ser un entero";
            }
        }
       
        int intentonas = (Integer) sesion.getAttribute("intentos")+1;
        
        
        
        
        try {
            
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
            out.println("<h3>"+respuesta+"</h3>");
            out.println("<p> Intento : "+intentonas+"</p>");
            out.println("<p> El numero magico es : "+numeroMagico+"</p>");
            if(respuesta.compareTo("G A N A S T E")!=0)
            {
                out.println("<p> <a href=\"Hamburguesas3.html\">Intentarlo de nuevo </a> </p>");
                out.println("<p> <a href=\"Giveup\">Te rindes ? </a> </p>");
                out.println("");
                sesion.setAttribute("intentos", intentonas);
                
            }
            else
            {
                out.println("<p> <a href=\"Hamburguesas3.html\">Jugar de nuevo </a> </p>");
                out.println("<p> <a href=\"Resultados\">Resultados </a> </p>");
                out.println("");
                //sesion.setAttribute("intentos", intentonas);
                sesion.setAttribute("hamburguesas", this.generaRandom());
                ganados=(Integer)sesion.getAttribute("ganados")+1;
                sesion.setAttribute("ganados", ganados);
                this.logger.info("GANO");
            }
            
            out.println("");
            out.println("");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
