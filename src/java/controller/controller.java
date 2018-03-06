package controller;

import beans.GestionClient;
import beans.beanAdresse;
import beans.beanClient;
import beans.beanExpediteur;
import beans.beanLogin;
import beans.beanPaiement;
import beans.beanPanier;
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
import obj.Adresse;
import obj.Client;
import obj.Evenement;
import obj.Expediteur;
import obj.LigneCommande;
import obj.OrganismePaiement;
import obj.Ouvrage;
import traitements.GestionEvenements;
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
        String section = request.getParameter("section");

//         String pageJSP = "/WEB-INF/jspLogin.jsp";
//        String pageJSP = "/WEB-INF/jspPanier.jsp";
//        String pageJSP = "/WEB-INF/jspPaiement.jsp";
        String pageJSP;
        if (request.getParameter("doIt") == null) {
            pageJSP = "/WEB-INF/jspHome.jsp";
        } else {
            if (getServletContext().getAttribute("beanLogin") == null) {
                try {
                    getServletContext().setAttribute("beanLogin", new beanLogin());
                } catch (NamingException ex) {
                    ex.printStackTrace();

                }
            }
            beanLogin bLogin = (beanLogin) getServletContext().getAttribute("beanLogin");
            if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
                pageJSP = "/WEB-INF/jspWelcome.jsp";
                String login = bLogin.nomPrenomClient(request.getParameter("login"));
                request.setAttribute("welcome", login);
                Cookie c = new Cookie("login", login);
                Cookie cEmail = new Cookie("email", request.getParameter("login"));
                response.addCookie(c);
                response.addCookie(cEmail);
                Cookie c2 = new Cookie("try", "");
                c2.setMaxAge(0);
                response.addCookie(c2);

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
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
        if (getServletContext().getAttribute("gestionOuvrages") == null) {
            try {
                getServletContext().setAttribute("gestionOuvrages", new GestionOuvrages());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        GestionOuvrages gestionOuvrages = (GestionOuvrages) getServletContext().getAttribute("gestionOuvrages");

        if (getServletContext().getAttribute("gestionEvenements") == null) {
            try {
                getServletContext().setAttribute("gestionEvenements", new GestionEvenements());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        
        GestionEvenements gestionEvenements = (GestionEvenements) getServletContext().getAttribute("gestionEvenements");
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanExpediteur") == null) {
            try {
                getServletContext().setAttribute("beanExpediteur", new beanExpediteur());
            } catch (NamingException ex) {
                ex.printStackTrace();

                //to do
            }
        }
        beanExpediteur beanEx = (beanExpediteur) getServletContext().getAttribute("beanExpediteur");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanPanier") == null) {
            try {
                getServletContext().setAttribute("beanPanier", new beanPanier());
            } catch (NamingException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        beanPanier beanPa = (beanPanier) getServletContext().getAttribute("beanPanier");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanLogin") == null) {
            try {
                getServletContext().setAttribute("beanLogin", new beanLogin());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanLogin bLogin = (beanLogin) getServletContext().getAttribute("beanLogin");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanPaiement") == null) {
            try {
                getServletContext().setAttribute("beanPaiement", new beanPaiement());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanPaiement beanPaie = (beanPaiement) getServletContext().getAttribute("beanPaiement");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanAdresse") == null) {
            try {
                getServletContext().setAttribute("beanAdresse", new beanAdresse());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanAdresse bAdresse = (beanAdresse) getServletContext().getAttribute("beanAdresse");

//////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("gestionClient") == null) {
            try {
                getServletContext().setAttribute("gestionClient", new GestionClient());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        GestionClient gestionClient = (GestionClient) getServletContext().getAttribute("gestionClient");

/////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanClient") == null) {
            try {
                getServletContext().setAttribute("beanClient", new beanClient());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        beanClient bClient = (beanClient) getServletContext().getAttribute("beanClient");
////////////////////////////////////////////////////////////////////////////////////////////////////            
        if ("login".equals(section)) {
            pageJSP = "/WEB-INF/jspLogin.jsp";
            Cookie c = getCookie(request.getCookies(), "login");
            if (c != null) {
                pageJSP = "/WEB-INF/jspWelcome.jsp";
                request.setAttribute("welcome", c.getValue());
            }

            if (request.getParameter("doIt") != null) {

                if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {
                    pageJSP = "/WEB-INF/jspWelcome.jsp";
                    String login = request.getParameter("login");
                    request.setAttribute("welcome", login);
                    c = new Cookie("login", login);
                    response.addCookie(c);
                    Cookie c2 = new Cookie("try", "");
                    c2.setMaxAge(0);
                    response.addCookie(c2);

                } else {

                    pageJSP = "/WEB-INF/jspLogin.jsp";
                    request.setAttribute("login", request.getParameter("login"));
                    request.setAttribute("msg", "Erreur login/Mot de passe !!!");
                    Cookie cTry = getCookie(request.getCookies(), "try");
                    if (cTry == null) {
                        cTry = new Cookie("try", "*");
                    } else {
                        cTry.setValue(cTry.getValue() + "*");
                    }
                    c.setMaxAge(5);
                    System.out.println(c.getValue());
                    response.addCookie(c);

                    if (cTry.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!");
                    }
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
        }

        
            if (request.getParameter("modifierCl") != null) {
                Cookie cl = getCookie(request.getCookies(), "email");
                Client c = bLogin.profilClient(cl.getValue());
                bClient.modifierClient(c.getIdClient(), request.getParameter("nom"),
                        request.getParameter("prenom"), request.getParameter("genre"),
                        request.getParameter("dateNaissance"), request.getParameter("email"),
                        request.getParameter("telephone"), request.getParameter("motDePasse"));
                pageJSP = "/WEB-INF/profilClient.jsp";
            }
        

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("catalogueAccueil".equals(section)) {
            pageJSP = "/WEB-INF/catalogueAccueil.jsp";
        }
        if ("catalogueTitre".equals(section)) {
            try {
                List<Ouvrage> lo = gestionOuvrages.findOuvragebyTitre(request.getParameter("titreRecherche"));
                request.setAttribute("titres", lo);
                pageJSP = "/WEB-INF/catalogueParTitre.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//        if ("catalogue".equals(section)) {
//            try {
//                HashMap<String, List<Ouvrage>> mo = gestionOuvrages.findOuvrages();
//                List<String> clefs = gestionOuvrages.getCleDefaut();
//                request.setAttribute("mapOuvrages", mo);
//                request.setAttribute("clefs", clefs);
//                pageJSP = "/WEB-INF/catalogue.jsp";
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
        if ("catalogue".equals(section)) {
            try {
                List<Ouvrage> lo = gestionOuvrages.findOuvrages2();
            request.setAttribute("liste", lo);
            pageJSP = "/WEB-INF/catalogueFull.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        if ("catalogue".equals(request.getParameter("section"))) {
//            try {
//                List<List<Integer>> OuvPagi = gestionOuvrages.getPagination(3);
//                HashMap<String, List<Ouvrage>> mo = gestionOuvrages.findOuvrages();
//                request.setAttribute("pages", OuvPagi);
//                request.setAttribute("mapOuv", mo);
//                pageJSP = "/WEB-INF/cataloguePagination.jsp";
//            } catch (SQLException ex) {
//                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        if ("panier".equals(request.getParameter("section"))) {
            beanPanier monPanier
                    = (beanPanier) session.getAttribute("monPanier");
            if (monPanier == null) {
                try {
                    monPanier = new beanPanier();
                    session.setAttribute("monPanier", monPanier);
                } catch (NamingException ex) {
                    ex.printStackTrace();
                }
            }
            if (request.getParameter("add") != null) {
                monPanier.addO(Integer.valueOf(request.getParameter("add")), request.getParameter("add2"), request.getParameter("add3"));
//                System.out.println("panier : "+monPanier.listO().toString());
//                beanPanier liste =  (beanPanier) session.getAttribute("monPanier");
//                String pan = liste.listO().toString();
//                System.out.println("liste : " +pan);

            }
            if (request.getParameter("dec") != null) {
                monPanier.decO(Integer.valueOf(request.getParameter("dec")));
            }
            if (request.getParameter("del") != null) {
                monPanier.delO(Integer.valueOf(request.getParameter("del")));
            }
            if (request.getParameter("clear") != null) {
                monPanier.clearO();
            }
            pageJSP = "/WEB-INF/catPan.jsp";
        }
        if ("affichePanier".equals(request.getParameter("section"))) {
            pageJSP = "/WEB-INF/panierCat.jsp";
            beanPanier monPanier
                    = (beanPanier) session.getAttribute("monPanier");
            if (monPanier == null) {
                try {
                    monPanier = new beanPanier();
                    session.setAttribute("monPanier", monPanier);
                } catch (NamingException ex) {
                    ex.printStackTrace();
                }
            }

            request.setAttribute("panierVide", monPanier.isEmptyO());
            request.setAttribute("list", monPanier.listO());
        }
        
        if ("evenement".equals(request.getParameter("section"))) {
            pageJSP = "/WEB-INF/evenement.jsp";
        }
        if ("evenementDate".equals(request.getParameter("section"))) {
             try {
                List<Evenement> le = gestionEvenements.findEvByDate();
                request.setAttribute("evenements", le);
                pageJSP = "/WEB-INF/evenementDate.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("afficher-client".equals(section)) {
            pageJSP = "/WEB-INF/profilClient.jsp";
            Cookie cl = getCookie(request.getCookies(), "email");
            Client c = bLogin.profilClient(cl.getValue());
            request.setAttribute("infoClientNom", c.getNom());
            request.setAttribute("infoClientPrenom", c.getPrenom());
            request.setAttribute("infoClientGenre", c.getGenre());
            request.setAttribute("infoClientDateNaissance", c.getDateNaissance());
            request.setAttribute("infoClientEmail", c.getEmail());
            request.setAttribute("infoClientTelephone", c.getTelephone());
            request.setAttribute("infoClientMotDePasse", c.getMotDePasse());
            request.setAttribute("infoClientNomStatut", c.getNomStatut());
            
             try {
                
                List<Adresse> mesAdresseF =  bAdresse.adresseClient(c.getIdClient(), "FACTURATION");
                request.setAttribute("listeAdresseF", mesAdresseF);
                
                List<Adresse> mesAdresseL =  bAdresse.adresseClient(c.getIdClient(), "LIVRAISON");
                request.setAttribute("listeAdresseL", mesAdresseL);
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
//            if (request.getParameter("modifier") != null) {
//
//                bClient.modifierClient(c.getIdClient(), request.getParameter("nom"),
//                        request.getParameter("prenom"), request.getParameter("genre"),
//                        request.getParameter("dateNaissance"), request.getParameter("email"),
//                        request.getParameter("telephone"), request.getParameter("motDePasse"));
//                
//            }
            
            
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
            if ("jspPanier".equals(section)){     
                
            pageJSP = "/WEB-INF/jspLogin.jsp";
            
            try {
                HashMap<String, List<LigneCommande>> mlc = beanPa.findCommande();
                List<String> clefs = beanPa.getLC();
                request.setAttribute("mapPanier", mlc);
                request.setAttribute("clefs", clefs);

                beanPanier livres = (beanPanier) session.getAttribute("monPanier");

                String pan = livres.listO().toString();
                session.setAttribute("livres", livres);
                session.setAttribute("voirPanier", pan);

//                request.setAttribute("livres", livres);
//                request.setAttribute("voirPanier", pan);
                System.out.println(session.getAttribute("voirPanier"));
                System.out.println(session.getAttribute("livres"));
                pageJSP = "/WEB-INF/jspPanier.jsp";

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("jspPaiement".equals(section)) {
            try {
                HashMap<String, List<OrganismePaiement>> mOp = beanPaie.findOrg();
                List<String> tables = beanPaie.getDefaultOrg();
                request.setAttribute("mapOrganisme", mOp);                
                request.setAttribute("tables", tables);
                pageJSP = "/WEB-INF/jspPaiement.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if ("jspCreerNvxCompteClientEtape1".equals(section)) {
            
            try {
                
                String nom = request.getParameter("nom");  //recuperation des infos du formulaire
                String prenom = request.getParameter("prenom");
                String genre = request.getParameter("genre");
                String dateNaissance = request.getParameter("dateNaissance");
                String email = request.getParameter("email");
                String telephone = request.getParameter("telephone");
                String motDePasse = request.getParameter("motDePasse");
                
                beanClient c = new beanClient();
                
                    
                try {
                    //                    request.setAttribute("nom",nom);
//                    request.setAttribute("prenom",prenom);
//                    request.setAttribute("genre",genre);
//                    request.setAttribute("dateNaissance",dateNaissance);
//                    request.setAttribute("email",email);
//                    request.setAttribute("telephone",telephone);
//                    request.setAttribute("motDePasse",motDePasse);
                    
                    c.insertClient(nom, prenom, genre, dateNaissance, email, telephone, motDePasse);
                    //todo: recuperer le nom et prenom pour les mettre dans la 2eme page
                } catch (SQLException ex) {
                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                
                pageJSP = "/WEB-INF/jspCreerNvxCompteClientEtape1.jsp";
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }    
                
            
//////////////////////////////////////////////////////           

        if ("jspCreerNvxCompteEtape2".equals(section)) {
            pageJSP = "/WEB-INF/jspCreerNvxCompteEtape2.jsp";

        }
//       
//        
//  // en attente de lien avec la page facturation de Momo      
//        if("payer".equals(section)){
//            pageJSP = "WEB-INF/jspCreerAdresseFacturation";
//        }
        pageJSP = response.encodeURL(pageJSP);

        getServletContext().getRequestDispatcher(pageJSP).include(request, response);
//        getServletContext().getRequestDispatcher(pageJSP).forward(request, response);

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
