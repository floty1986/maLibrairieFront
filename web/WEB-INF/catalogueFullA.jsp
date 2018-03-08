
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue-Panier</title>
    </head>
    <body>
        <h1 class="centre">Catalogue</h1>
        <div class="left">
            <form action="controller?section=goAccueil" method="POST">
                <input type="submit" value="Accueil" name="goAccueil"  />
            </form>
        </div>
        <div class="center"
            <form action="controller?section=catalogueTitre" method="POST" class="centre">
                <input type="text" name="titreRecherche" value="Recherche par Titre" />
                <input type="submit" value="Chercher" name="chercherTitre" />
            </form>
        </div>
        <hr>
        <table class="tableau">
            <tr>
                <th scope="col" class="tableau">Titre-Auteur</th>
                <th scope="col" class="tableau">Couverture</th>  
                <th scope="col" class="tableau">Prix-Disponibilité</th>
            </tr>
            <c:forEach items="${liste}" var="o" >
                <tr>
                    <td class="tableau">
                        <a href='controller?section=panierA&add=${o.idOuvrage}&add2=${o.titre}&add3=${o.imageOuvrage}&add4=${o.prix}&add5=${o.qteStockee}&add6=${o.statut}'>***Titre : <strong>${o.titre}</strong>***<br>Auteur : <strong2>${mapAuteurs.get(o.idOuvrage)}</strong2></a></td>
                    <td class="tableau"><p><a href='controller?section=panierA&add=${o.idOuvrage}&add2=${o.titre}&add3=${o.imageOuvrage}&add4=${o.prix}&add5=${o.qteStockee}&add6=${o.statut}'> <img src='${o.imageOuvrage}' alt='${o.titre}'/></a></P></td>
                    <td class="tableau">
                        <a href='controller?section=panierA&add=${o.idOuvrage}&add2=${o.titre}&add3=${o.imageOuvrage}&add4=${o.prix}&add5=${o.qteStockee}&add6=${o.statut}'>***Prix : <strong3>${o.prix}</strong3>€***<br><br>Cet ouvrage est : <strong3>${o.statut}</strong3></a></td>
                </tr>     
            </c:forEach>
        </table>
        <hr>
        <div class="footer">
            <h3>Panier : </h3>
            <jsp:include page="/controller?section=affichePanier" flush="true"/>
            <c:url value="controller?section=jspPanier" var="url03" />
            <a href="${url03}">Valider panier</a>
            <hr>
            <c:url value="controller?section=login" var="url01" />                                    
            <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>
            <a href = 'controller?section=jspPanier'><input type="submit" value="Voir Panier !" name="voirPanier" /></a>

        </div>
    </body>
</html>
