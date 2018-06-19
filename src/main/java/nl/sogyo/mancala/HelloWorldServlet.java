package nl.sogyo.mancala;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
           throws ServletException, IOException {
       PrintWriter out = response.getWriter();
       out.println("<html><body>Hello, World!</body></html>");
   }
}
