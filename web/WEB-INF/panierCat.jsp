<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<c:if test="${panierVide}">
    Panier vide !    
</c:if>
<c:if test="${!panierVide}">
    <table class="tableau">
        <tr>
            <th scope="col" class="tableau">Titre</th>
            <th scope="col" class="tableau">Quantité Panier</th>
            <th scope="col" class="tableau">Ajouter 1</th>
            <th scope="col" class="tableau">Retirer 1</th>
            <th scope="col" class="tableau">Supprimer Panier</th>
        </tr>
        <c:forEach var="i" items="${list}">
            <tr>
                <td class="tableau">${i.titre}</td>
                <td class="tableau">${i.qtePanier}</td>
                <td class="tableau"><a href='controller?section=panierA&add=${i.idOuvrage}&add2=${i.titre}&add3=${i.imageOuvrage}&add4=${i.prix}&add5=${i.qteStockee}&add6=${i.statut}'>(+1)</a></td>
                <td class="tableau"><a href='controller?section=panierA&dec=${i.idOuvrage}'>(-1)</a></td>
                <td class="tableau"><a href='controller?section=panierA&del=${i.idOuvrage}'>(X)</a></td>
            </tr>        
        </c:forEach>
    </table>
    <a href='controller?section=panierA&clear'><input type="submit" value="Vider le Panier !" name="vider" /></a>
        <c:url value="controller?section=jspPanier" var="url03" />
    <a href="${url03}"><input type="submit" value="Voir Panier !" name="see" /></a>
    </c:if>
