package controller;

import beans.beanExpediteur;
import beans.beanLogin;
import beans.beanPanier;
//import beans.beanPanier;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
import obj.Expediteur;
import obj.LigneCommande;
import obj.Ouvrage;
import traitements.GestionOuvrages;

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

//         String pageJSP = "/WEB-INF/jspLogin.jsp";
//        String pageJSP = "/WEB-INF/jspPanier.jsp";
        String pageJSP = "/WEB-INF/jspMain.jsp";
        String section = request.getParameter("section");

        if (getServletContext().getAttribute("gestionOuvrages") == null) {
            try {
                getServletContext().setAttribute("gestionOuvrages", new GestionOuvrages());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        GestionOuvrages gestionOuvrages = (GestionOuvrages) getServletContext().getAttribute("gestionOuvrages");

        if (getServletContext().getAttribute("beanExpediteur") == null) {
            try {
                getServletContext().setAttribute("beanExpediteur", new beanExpediteur());
            } catch (NamingException ex) {
                ex.printStackTrace();

                //to do
            }
        }
        beanExpediteur beanEx = (beanExpediteur) getServletContext().getAttribute("beanExpediteur");

        if (getServletContext().getAttribute("beanPanier") == null) {
            try {
                getServletContext().setAttribute("beanPanier", new beanPanier());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }

        beanPanier beanPa = (beanPanier) getServletContext().getAttribute("beanPanier");

        if ("login".equals(section)) {
            pageJSP = "/WEB-INF/jspLogin.jsp";

            if (request.getParameter("doIt") != null) {

                beanLogin bLogin = (beanLogin) session.getAttribute("beanLogin");
                if (bLogin == null) {
                    try {
                        bLogin = new beanLogin();
                    } catch (NamingException ex) {
                        ex.printStackTrace();
                    }
                    session.setAttribute("beanLogin", bLogin);
                }
                try {

                    if (bLogin.check(request.getParameter("login"),
                            request.getParameter("password"))) {

                        pageJSP = "/WEB-INF/jspWelcome.jsp";
                        request.setAttribute("welcome", request.getParameter("login"));
                        Cookie c = new Cookie("login", request.getParameter("login"));
                        response.addCookie(c);
                        c = new Cookie("try", "");
                        c.setMaxAge(0);
                        response.addCookie(c);
                    } else {
                        pageJSP = "/WEB-INF/jspLoginError.jsp";
                        request.setAttribute("login", request.getParameter("login"));
                        request.setAttribute("msg", "Erreur login/Mot de passe !!!");
                        Cookie c = getCookie(request.getCookies(), "try");
                        if (c == null) {
                            c = new Cookie("try", "*");
                        } else {
                            c.setValue(c.getValue() + "*");
                        }
                        c.setMaxAge(90);
                        response.addCookie(c);
                        if (c.getValue().length() >= 3) {
                            pageJSP = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", "Trop de tentatives !!!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }

            ////////////////////////////////////////////////////////////////////////////////////
//            if ("panier".equals(request.getParameter("section"))) {
//                beanPanier monPanier
//                        = (beanPanier) session.getAttribute("monPanier");
//                if (monPanier == null) {
//                    monPanier = new beanPanier();
//                    session.setAttribute("monPanier", monPanier);
//                }
//                if (request.getParameter("add") != null) {
//                    monPanier.add(request.getParameter("add"));
//                }
//                if (request.getParameter("dec") != null) {
//                    monPanier.dec(request.getParameter("dec"));
//                }
//                if (request.getParameter("del") != null) {
//                    monPanier.del(request.getParameter("del"));
//                }
//                if (request.getParameter("clear") != null) {
//                    monPanier.clear();
//                }
//            }
//            if ("affichePanier".equals(request.getParameter("section"))) {
//                pageJSP = "/WEB-INF/jspPanier.jsp";
//                beanPanier monPanier
//                        = (beanPanier) session.getAttribute("monPanier");
//                if (monPanier == null) {
//                    monPanier = new beanPanier();
//                    session.setAttribute("monPanier", monPanier);
//                }
//                request.setAttribute("panierVide", monPanier.isEmpty());
//                request.setAttribute("list", monPanier.list());
//            }
            ////////////////////////////////////////////////////////////////////////////////////
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
        }
        if ("catalogue".equals(section)) {

            try {
                HashMap<String, List<Ouvrage>> mo = gestionOuvrages.findOuvrages();
                List<String> clefs = gestionOuvrages.getCleDefaut();
                request.setAttribute("mapOuvrages", mo);
                request.setAttribute("clefs", clefs);
                pageJSP = "/WEB-INF/catalogue.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();

            }

        }
        if ("jspPanier".equals(section)) {
                try {
                    HashMap<String, List<LigneCommande>> mlc = beanPa.findCommande();
                    List<String> clefs = beanPa.getLC();
                    request.setAttribute("mapPanier", mlc);
                    request.setAttribute("clefs", clefs);
                    pageJSP = "/WEB-INF/jspPanier.jsp";
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }


        if ("jspLivraison".equals(section)) {

            try {
                HashMap<String, List<Expediteur>> me = beanEx.findExpediteur();
                List<String> tables = beanEx.getDefaultTable();
                request.setAttribute("mapExpediteur", me);
                request.setAttribute("tables", tables);
                pageJSP = "/WEB-INF/jspLivraison.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();
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
