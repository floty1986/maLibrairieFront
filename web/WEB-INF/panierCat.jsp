<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<c:if test="${panierVide}">
    Panier vide !    
</c:if>
    
<c:if test="${!panierVide}">
    <c:forEach var="i" items="${list}">
        ${i.titre} / Quantité : ${i.qtePanier} 
        <a href='controller?section=panier&add=${i.idOuvrage}&add2=${i.titre}'><input type="submit" value="Ajouter 1" name="ajout" class="btn_ajout" /></a>
        <a href='controller?section=panier&dec=${i.idOuvrage}'><input type="submit" value="Retirer 1" name="retrait"  class="btn"/></a>
        <a href='controller?section=panier&del=${i.idOuvrage}'><input type="submit" value="Supprimer" name="suppression" class="btn"/></a>

        <br>        
    </c:forEach>
        <a href='controller?section=panier&clear'><input type="submit" value="Vider le Panier !" name="vider" /></a>         
</c:if>
