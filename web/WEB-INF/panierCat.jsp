<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<c:if test="${panierVide}">
    Panier vide !    
</c:if>
<c:if test="${!panierVide}">
    <table class="centre">
        <tr>
            <th scope="col" class="centre">Titre</th>
            <th scope="col" class="centre">Quantité Panier</th>
            <th scope="col" class="centre">Ajouter 1</th>
            <th scope="col" class="centre">Retirer 1</th>
            <th scope="col" class="centre">Supprimer Panier</th>
        </tr>
        <c:forEach var="i" items="${list}">
            <tr>
                <td class="centre">${i.titre}</td>
                <td class="centre">${i.qtePanier}</td>
                <td class="centre"><a href='controller?section=panier&add=${i.idOuvrage}&add2=${i.titre}&add3=${i.imageOuvrage}'>(+1)</a></td>
                <td class="centre"><a href='controller?section=panier&dec=${i.idOuvrage}'>(-1)</a></td>
                <td class="centre"><a href='controller?section=panier&del=${i.idOuvrage}'>(X)</a></td>
            </tr>        
        </c:forEach>
    </table>
    <a href='controller?section=panier&clear'><input type="submit" value="Vider le Panier !" name="vider" /></a>
        <c:url value="controller?section=jspPanier" var="url03" />
    <a href="${url03}"><input type="submit" value="Voir Panier !" name="see" /></a>
    </c:if>
