package controller;

import beans.beanAdresse;
import beans.beanClient;
import beans.beanCommande;
import beans.beanExpediteur;
import beans.beanLigneCommande;
import beans.beanLogin;
import beans.beanPaiement;
import beans.beanPanier;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
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
import obj.Commande;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String section = request.getParameter("section");
        String pageJSP;

        pageJSP = "/WEB-INF/jspHome.jsp";

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

            }
        }
        beanExpediteur beanEx = (beanExpediteur) getServletContext().getAttribute("beanExpediteur");
        if (getServletContext().getAttribute("beanPanier") == null) {
            try {
                getServletContext().setAttribute("beanPanier", new beanPanier());
            } catch (NamingException ex) {
                Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        beanPanier beanPa = (beanPanier) getServletContext().getAttribute("beanPanier");
        if (getServletContext().getAttribute("beanLogin") == null) {
            try {
                getServletContext().setAttribute("beanLogin", new beanLogin());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanLogin bLogin = (beanLogin) getServletContext().getAttribute("beanLogin");
        if (getServletContext().getAttribute("beanPaiement") == null) {
            try {
                getServletContext().setAttribute("beanPaiement", new beanPaiement());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanPaiement beanPaie = (beanPaiement) getServletContext().getAttribute("beanPaiement");
        if (getServletContext().getAttribute("beanAdresse") == null) {
            try {
                getServletContext().setAttribute("beanAdresse", new beanAdresse());
            } catch (NamingException ex) {
                ex.printStackTrace();

            }
        }
        beanAdresse bAdresse = (beanAdresse) getServletContext().getAttribute("beanAdresse");

        if (getServletContext().getAttribute("beanClient") == null) {
            try {
                getServletContext().setAttribute("beanClient", new beanClient());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        beanClient bClient = (beanClient) getServletContext().getAttribute("beanClient");
////////////////////////////////////////////////////////////////////////////////////////////////////
        if (getServletContext().getAttribute("beanCommande") == null) {
            try {
                getServletContext().setAttribute("beanCommande", new beanCommande());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        beanCommande bCommande = (beanCommande) getServletContext().getAttribute("beanCommande");
////////////////////////////////////////////////////////////////////////////////////////////////////

        if (getServletContext().getAttribute("beanLigneCommande") == null) {
            try {
                getServletContext().setAttribute("beanLigneCommande", new beanLigneCommande());
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        beanLigneCommande bLigneCommande = (beanLigneCommande) getServletContext().getAttribute("beanLigneCommande");
////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("login".equals(section)) {
            pageJSP = "/WEB-INF/jspLogin.jsp";

            Cookie c03 = getCookie(request.getCookies(), "email");
            Cookie c06 = getCookie(request.getCookies(), "login");
            if (c03 != null) {
                pageJSP = "/WEB-INF/jspWelcome.jsp";
                request.setAttribute("welcome", c06.getValue());
            }

            if (request.getParameter("doIt") != null) {

                if (bLogin.check(request.getParameter("login"), request.getParameter("password"))) {

                    pageJSP = "/WEB-INF/jspWelcome.jsp";
                    String login = bLogin.nomPrenomClient(request.getParameter("login"));
//                    Cookie cNom = new Cookie("nom", login);
                    request.setAttribute("welcome", login);
                    Cookie c = new Cookie("login", login);
                    Cookie cEmail = new Cookie("email", request.getParameter("login"));
                    response.addCookie(c);
                    response.addCookie(cEmail);
//                    response.addCookie(cNom);
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
                    cTry.setMaxAge(5);

                    response.addCookie(cTry);

                    if (cTry.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!");
                    }
//                     Cookie z = new Cookie("validationPanier", request.getParameter("monPanier")); 
                }

                if (request.getParameter("deconnect") != null) {
                    pageJSP = "/WEB-INF/jspLogin.jsp";
                    request.setAttribute("login", c03.getValue());
                    Cookie cc = new Cookie("login", "");
                    cc.setMaxAge(0);
                    response.addCookie(cc);
                }
                Cookie c05 = getCookie(request.getCookies(), "try");
                if (c05 != null) {
                    if (c05.getValue().length() >= 3) {
                        pageJSP = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", "Trop de tentatives !!!!!");
                    }
                }

            }
        }

        if (request.getParameter("modifierCl") != null) {
            Cookie cl = getCookie(request.getCookies(), "email");            
            String login = bLogin.nomPrenomClient(cl.getValue());
            request.setAttribute("welcome", login);
            Client c = bLogin.profilClient(cl.getValue());
            bClient.modifierClient(c.getIdClient(), request.getParameter("nom"),
                    request.getParameter("prenom"), request.getParameter("genre"),
                    request.getParameter("dateNaissance"), request.getParameter("email"),
                    request.getParameter("telephone"), request.getParameter("motDePasse"));
            pageJSP = "/WEB-INF/jspWelcome.jsp";
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("catalogueAccueil".equals(section)) {
            pageJSP = "/WEB-INF/catalogueAccueil.jsp";
        }
        if ("catalogueTitre".equals(section)) {
            try {
                List<Ouvrage> lo = gestionOuvrages.findOuvragebyTitre(request.getParameter("titreRecherche"));
                request.setAttribute("titres", lo);
                int nbO = lo.size();
                request.setAttribute("nbOuv", nbO);
                HashMap<Integer, String> ma = gestionOuvrages.findAuteur();
                request.setAttribute("mapAuteurs", ma);
                request.setAttribute("recherche", request.getParameter("titreRecherche"));
                pageJSP = "/WEB-INF/catalogueParTitre.jsp";
            } catch (SQLException ex) {
                ex.printStackTrace();
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
                HashMap<Integer, String> ma = gestionOuvrages.findAuteur();
                request.setAttribute("mapAuteurs", ma);
                pageJSP = "/WEB-INF/catalogueFull.jsp";

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if ("catalogueA".equals(section)) {
            try {
                List<Ouvrage> lo = gestionOuvrages.findOuvrages2();
                request.setAttribute("liste", lo);
                HashMap<Integer, String> ma = gestionOuvrages.findAuteur();
                request.setAttribute("mapAuteurs", ma);
                pageJSP = "/WEB-INF/catalogueFullA.jsp";

            } catch (SQLException ex) {
                ex.printStackTrace();
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
        if ("panierA".equals(request.getParameter("section"))) {
            pageJSP = "/WEB-INF/catPan.jsp";
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
                monPanier.addO(Integer.valueOf(request.getParameter("add")), request.getParameter("add2"), request.getParameter("add3"), Float.valueOf(request.getParameter("add4")), Integer.valueOf(request.getParameter("add5")), request.getParameter("add6"));
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
        }

        if ("panier".equals(request.getParameter("section"))) {

            pageJSP = "/WEB-INF/jspWelcome.jsp";
            Cookie cEmail = getCookie(request.getCookies(), "email");
            String login = bLogin.nomPrenomClient(cEmail.getValue());
//                    Cookie cNom = new Cookie("nom", login);
            request.setAttribute("welcome", login);
            Cookie c = new Cookie("login", login);
            response.addCookie(c);
            response.addCookie(cEmail);
//                    response.addCookie(cNom);
            Cookie c2 = new Cookie("try", "");
            c2.setMaxAge(0);
            response.addCookie(c2);
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
                monPanier.addO(Integer.valueOf(request.getParameter("add")), request.getParameter("add2"), request.getParameter("add3"), Float.valueOf(request.getParameter("add4")), Integer.valueOf(request.getParameter("add5")), request.getParameter("add6"));
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
            if (getCookie(request.getCookies(), "login") != null) {
                Cookie cn = getCookie(request.getCookies(), "login");
                request.setAttribute("nom", cn.getValue());
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
                ex.printStackTrace();
            }
        }
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

            //try {
            try {

                List<Adresse> mesAdresseF = bAdresse.adresseClient(c.getIdClient(), "FACTURATION");
                request.setAttribute("listeAdresseF", mesAdresseF);

                List<Adresse> mesAdresseL = bAdresse.adresseClient(c.getIdClient(), "LIVRAISON");
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

        if ("jspPanier".equals(section)) {

            pageJSP = "/WEB-INF/jspPanier.jsp";
            beanPanier livres = (beanPanier) session.getAttribute("monPanier");
            Collection<Ouvrage> pan = livres.listO();
            List<String> clefs = beanPa.getLC();
            request.setAttribute("clefPanier", clefs);
            session.setAttribute("voirPanier", pan);
        }
        if (request.getParameter("validPanier") != null || "jspLivraison".equals(section)) {

            Cookie c01 = getCookie(request.getCookies(), "login");
//            response.addCookie(z);
            if (c01 == null) {
                pageJSP = "/WEB-INF/jspLogin.jsp";
                Cookie z = new Cookie("validationPanier", request.getParameter("monPanier"));
                response.addCookie(z);
            } else {
                try {
                    pageJSP = "/WEB-INF/jspLivraison.jsp";
                    Cookie cl = getCookie(request.getCookies(), "email");
                    Client c = bLogin.profilClient(cl.getValue());
                    request.setAttribute("infoClientNom", c.getNom());
                    request.setAttribute("infoClientPrenom", c.getPrenom());

                    HashMap<String, List<Expediteur>> me = beanEx.findExpediteur();
                    List<String> tables = beanEx.getDefaultTable();
                    request.setAttribute("mapExpediteur", me);
                    request.setAttribute("tables", tables);
//                    pageJSP = "/WEB-INF/jspLivraison.jsp";

//                beanPanier add = (beanPanier) session.getAttribute("monPanier");
//                String panLiv = add.listO().toString();
                    session.getAttribute("monPanier");
                    session.getAttribute("livres");
//                    request.getAttribute("listeAdresseF");
//                    request.getAttribute("listeAdresseL");

                    List<Adresse> mesAdresseF = bAdresse.adresseClient(c.getIdClient(), "FACTURATION");
                    request.setAttribute("listeAdresseF", mesAdresseF);

                    List<Adresse> mesAdresseL = bAdresse.adresseClient(c.getIdClient(), "LIVRAISON");
                    request.setAttribute("listeAdresseL", mesAdresseL);

                    List<Ouvrage> lo;
                    try {
                        lo = gestionOuvrages.findOuvrages2();
                        request.setAttribute("liste", lo);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
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
        boolean aff = false;
        if ("historiqueCommande".equals(section)) {
            pageJSP = "/WEB-INF/historiqueCommande.jsp";
            try {
                Cookie cl = getCookie(request.getCookies(), "email");
                Cookie cn = getCookie(request.getCookies(), "login");
                Client c = bLogin.profilClient(cl.getValue());
                List<Commande> lco = bCommande.findCommande(c.getIdClient());
                request.setAttribute("listeCommande", lco);
                request.setAttribute("nom", cn.getValue());

                String numC = request.getParameter("numCommande");

                if (!"".equals(numC) && numC != null) {
                    aff = true;
                    request.setAttribute("affLC", aff);
                    int numCo = Integer.valueOf(numC);
                    request.setAttribute("numC", numC);

                    List<LigneCommande> lC = bLigneCommande.findLigneCommandeCl(numCo);
                    request.setAttribute("listeLigneCommande", lC);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if ("jspCreerNvxCompteClientEtape1".equals(section)) {
            //System.out.println(">>>>" + section);
            pageJSP = "/WEB-INF/jspCreerNvxCompteClientEtape1.jsp";
        }
        if ("jspCreerNvxCompteClientEtape2".equals(section)) {
            //System.out.println(">>>>" + section + "/" + request.getParameter("nom"));
            pageJSP = "WEB-INF/jspCreerNvxCompteClientEtape2.jsp";

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
                    String nomStatut = ("actif");
                    request.setAttribute("nom", nom);
                    request.setAttribute("prenom", prenom);
                    request.setAttribute("genre", genre);
                    request.setAttribute("dateNaissance", dateNaissance);
                    request.setAttribute("email", email);
                    request.setAttribute("telephone", telephone);
                    request.setAttribute("motDePasse", motDePasse);
                    Cookie cEmail = new Cookie("email", email);
                    response.addCookie(cEmail);
                    c.insertClient(nom, prenom, genre, dateNaissance, email, telephone, motDePasse, nomStatut);
                    //todo: recuperer le nom et prenom pour les mettre dans la 2eme page
                } catch (SQLException | ParseException ex) {
                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                pageJSP = "/WEB-INF/jspCreerNvxCompteClientEtape2.jsp";
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }

        if ("jspCreerNvxCompteClientEtape3".equals(section)) {

            try {

                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String email = request.getParameter("email");
                String numVoie = request.getParameter("numVoie");
                String typeVoie = request.getParameter("typeVoie");
                String nomVoie = request.getParameter("nomVoie");
                String ville = request.getParameter("ville");
                String codePostal = request.getParameter("codePostal");
                String pays = request.getParameter("pays");
                String telephone = request.getParameter("telephone");
                String complement = request.getParameter("complement");

                beanAdresse a = new beanAdresse();

                try {
                    String nomStatut = ("actif");
                    String typeAdresse = ("LIVRAISON");
                    request.setAttribute("nom", nom);
                    request.setAttribute("prenom", prenom);
                    request.setAttribute("email", email);
                    request.setAttribute("numVoie", numVoie);
                    request.setAttribute("typeVoie", typeVoie);
                    request.setAttribute("nomVoie", nomVoie);
                    request.setAttribute("ville", ville);
                    request.setAttribute("codePostal", codePostal);
                    request.setAttribute("pays", pays);
                    request.setAttribute("telephone", telephone);
                    request.setAttribute("complement", complement);

                    a.insertAdresse(typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if ("oui".equals(request.getParameter("adrFacturation"))) {
                    String nomStatut = ("actif");
                    String typeAdresse = ("FACTURATION");
                    request.setAttribute("nom", nom);
                    request.setAttribute("prenom", prenom);
                    request.setAttribute("email", email);
                    request.setAttribute("numVoie", numVoie);
                    request.setAttribute("typeVoie", typeVoie);
                    request.setAttribute("nomVoie", nomVoie);
                    request.setAttribute("ville", ville);
                    request.setAttribute("codePostal", codePostal);
                    request.setAttribute("pays", pays);
                    request.setAttribute("telephone", telephone);
                    request.setAttribute("complement", complement);

                    a.insertAdresse(typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut);
                }

            } catch (NamingException | SQLException ex) {
                ex.printStackTrace();
            }

            pageJSP = "/WEB-INF/jspWelcome.jsp";
            Cookie cEmail = getCookie(request.getCookies(), "email");
            String login = bLogin.nomPrenomClient(cEmail.getValue());
            Cookie cNom = new Cookie("nom", login);
            request.setAttribute("welcome", login);
            Cookie c = new Cookie("login", login);

            response.addCookie(c);

            response.addCookie(cNom);
            Cookie c2 = new Cookie("try", "");
            c2.setMaxAge(0);
            response.addCookie(c2);
        }
        if (request.getParameter("ajouterAdresse") != null) {
            Cookie cn = getCookie(request.getCookies(), "login");
            Cookie cEmail = getCookie(request.getCookies(), "email");
            request.setAttribute("nom", cn.getValue());
            Client cl = bLogin.profilClient(cEmail.getValue());
            Cookie idC = new Cookie("idClient", String.valueOf(cl.getIdClient()));
            response.addCookie(idC);
            pageJSP = "/WEB-INF/jspAjouterAdresse.jsp";

        }

        if ("ajouterAdresse".equals(section)) {

            if (request.getParameter("ajout") != null) {
                Cookie cEmail = getCookie(request.getCookies(), "email");
                String login = bLogin.nomPrenomClient(cEmail.getValue());
                Cookie cNom = new Cookie("nom", login);
                request.setAttribute("welcome", login);
                Cookie c = new Cookie("login", login);
                response.addCookie(c);
                response.addCookie(cNom);
                Cookie c2 = new Cookie("try", "");
                c2.setMaxAge(0);
                response.addCookie(c2);
                pageJSP = "/WEB-INF/jspWelcome.jsp";
                try {
                    String nomStatut = ("actif");
                    String typeAdresse = request.getParameter("typeAdresse");
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String email = request.getParameter("email");
                    String numVoie = request.getParameter("numVoie");
                    String typeVoie = request.getParameter("typeVoie");
                    String nomVoie = request.getParameter("nomVoie");
                    String ville = request.getParameter("ville");
                    String codePostal = request.getParameter("codePostal");
                    String pays = request.getParameter("pays");
                    String telephone = request.getParameter("telephone");
                    String complement = request.getParameter("complement");

                    beanAdresse a = new beanAdresse();
                    int idClient = Integer.valueOf(getCookie(request.getCookies(), "idClient").getValue());

                    a.ajouterAdresse(idClient, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut);

                } catch (NamingException | SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }

        if ("supprimerAdFact".equals(section)) {
            try {

                int idAdresse = Integer.valueOf(request.getParameter("idAdresse"));
                bAdresse.supAdresse(idAdresse);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if ("supprimerAdLiv".equals(section)) {

            try {

                int idAdresse = Integer.valueOf(request.getParameter("idAdresse"));
                bAdresse.supAdresse(idAdresse);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

//////////////////////////////////////////////////////    
//        if ("jspCreerNvxCompteEtape2".equals(section)) {
//            if (request.getParameter("NvxCompte2") != null) {
//                pageJSP = "/WEB-INF/jspCreerNvxCompteEtape2.jsp";
//            }
//
//
//        }
//       
//        
//  // en attente de lien avec la page facturation de Momo      
//        if("payer".equals(section)){
//            pageJSP = "WEB-INF/jspCreerAdresseFacturation";
//        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
