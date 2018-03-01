
package controller;


import beans.beanLogin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String pageJSP = "/WEB-INF/jspHome.jsp";
        String section = request.getParameter("section");

        if (getServletContext().getAttribute("beanLogin") == null) {
            try {
                getServletContext().setAttribute("beanLogin", new beanLogin());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanLogin bLogin = (beanLogin) getServletContext().getAttribute("beanLogin");
        

        if ("login".equals(section)) {
            pageJSP = "/WEB-INF/jspLogin.jsp";

            if (request.getParameter("doIt") != null ) {
                
                try {
                    if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
                        pageJSP = "/WEB-INF/jspWelcome.jsp";
                        String login = request.getParameter("login");
                        request.setAttribute("welcome", login);
                        Cookie c = new Cookie("login", login);                    
                        response.addCookie(c);
                        c = new Cookie("try", "");
                        c.setMaxAge(0);                        
                        response.addCookie(c);

                    } else {

                        pageJSP = "/WEB-INF/jspLogin.jsp";
                        request.setAttribute("login", request.getParameter("login"));
                        request.setAttribute("msg", "Erreur login/Mot de passe !!!");
                        Cookie c = getCookie(request.getCookies(), "try");
                        if (c == null) {
                            c = new Cookie("try", "*");                            
                        } else {
                            c.setValue(c.getValue() + "*");
                        }
                        c.setMaxAge(90);
                        System.out.println(c.getValue());
                        response.addCookie(c);
                        
                        if (c.getValue().length() >= 3) {
                            pageJSP = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", "Trop de tentatives !!!");
                        }
                    }
                    
                    Cookie c = getCookie(request.getCookies(), "login");
                    if (c != null) {
                        pageJSP = "/WEB-INF/jspWelcome.jsp";
                        request.setAttribute("welcome", c.getValue());
                    }
                    if (request.getParameter("deconnect") != null) {
                        pageJSP = "/WEB-INF/jspLogin.jsp";
                        request.setAttribute("login", c.getValue());
                        Cookie cc = new Cookie("login", "");
                        cc.setMaxAge(0);
                        response.addCookie(cc);
                    }
                    c = getCookie(request.getCookies(), "try");
                    if (c != null) {
                        if (c.getValue().length() >= 3) {
                            pageJSP = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", "Trop de tentatives !!!!!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }

        pageJSP = response.encodeURL(pageJSP);
       
        getServletContext().getRequestDispatcher(pageJSP).include(request, response);

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
