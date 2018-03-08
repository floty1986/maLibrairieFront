<%@page import="obj.Ouvrage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>catalogue par titre</title>
    </head>
    <body>
        <h1>Catalogue Par Titre</h1>
        <form action="controller?section=catalogueTitre" method="POST">
            <input type="text" name="titreRecherche" value="Recherche par titre" />
            <input type="submit" value="Chercher" name="chercherTitre" />
        </form>
        <form action="controller?section=catalogue" method="POST" >
            <input type="submit" value="Voir tout le Catalogue" name="catFull" class="btn_cat"/>
        </form>
        <hr>
        <h3>${nbOuv} Titre(s) trouvés pour la recherche "<strong color="red">${recherche}</strong>" :</h3>
        <table class="tableau">
            <tr>
                <th scope="col" class="tableau">Titre-Auteur</th>
                <th scope="col" class="tableau">Couverture</th>  
                <th scope="col" class="tableau">Prix-Disponibilité</th>
            </tr>
            <c:forEach items="${titres}" var="t" >
                <tr>
                    <td class="tableau">
                        <a href='controller?section=panier&add=${t.idOuvrage}&add2=${t.titre}&add3=${t.imageOuvrage}&add4=${t.prix}&add5=${t.qteStockee}&add6=${t.statut}'>***Titre : ${t.titre}***<br>***Auteur : ${mapAuteurs.get(t.idOuvrage)}***</a></td>
                    <td class="tableau"><p><a href='controller?section=panier&add=${t.idOuvrage}&add2=${t.titre}&add3=${t.imageOuvrage}&add4=${t.prix}&add5=${t.qteStockee}&add6=${t.statut}'> <img src='${t.imageOuvrage}' alt='${t.titre}'/></a></P></td>
                    <td class="tableau">
                        <a href='controller?section=panier&add=${t.idOuvrage}&add2=${t.titre}&add3=${t.imageOuvrage}&add4=${t.prix}&add5=${t.qteStockee}&add6=${t.statut}'>***Prix : ${t.prix}€***<br><br>***${t.qteStockee} unité(s) disponible(s)***</a></td>
                </tr>     
            </c:forEach>
        </table>
        <hr>
        <div class="footer">
            <h3>Panier : </h3>
            <jsp:include page="/controller?section=affichePanier" flush="true"/>
            
            <hr>
            <c:url value="controller?section=login" var="url01" />                                    
            <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>
            
        </div>
    </body>
</html>
