
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>

<h1>Catalogue</h1>
<hr>
<table class='centre'>
    <tr>
        <th scope="col" class="centre">Titre</th>
        <th scope="col" class="centre">Couverture</th>           
    </tr>
    <c:forEach items="${liste}" var="o" >
        <tr>
            <td class="centre">
                <a href='controller?section=panier&add=${o.idOuvrage}&add2=${o.titre}&add3=${o.imageOuvrage}'>*** Titre : ${o.titre}***</a></td>
            <td class="centre"><p><a href='controller?section=panier&add=${o.idOuvrage}&add2=${o.titre}&add3=${o.imageOuvrage}'> <img src='${o.imageOuvrage}' alt='${o.titre}'/></a></P></td>                
        </tr>     
    </c:forEach>
</table>
<hr>
<div class="footer">
    <h4>Panier : </h4>
    <jsp:include page="/controller?section=affichePanier" flush="true"/>
    <c:url value="controller?section=jspPanier" var="url03" />
    <a href="${url03}">Valider panier</a>
    <hr>
    <c:url value="controller?section=login" var="url01" />                                    
    <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>
    <a href = 'controller?section=jspPanier'><input type="submit" value="Voir Panier !" name="voirPanier" /></a>
    <hr>
    <a href='controller?deconnect'><input type='submit' name='deconnecter' value='Deconnexion' /></a>
    <br>
    <hr>
    <a href='controller?section=afficher-client'><input type='submit' name='profilClient' value='profil ${welcome}' /></a>
    
    <a href='controller?section=historiqueCommande'><input type='submit' name='historiqueCommande' value='Historique de commande ${welcome}' /></a><br/>

</div>
