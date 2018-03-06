<%@page import="obj.Ouvrage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>


<c:forEach items="${clefs}" var="c" >
    <h1>${c}</h1>
        
    <ul>
        <c:forEach items="${mapOuvrages.get(c)}" var="p">
            <li>

                <a href='controller?section=panier&add=${p.idOuvrage}&add2=${p.titre}&add3=${p.imageOuvrage}'>Numéro ID : ${p.idOuvrage}*** Titre : ${p.titre}***${p.imageOuvrage}</a>
            </li>
        </c:forEach>
    </ul>
    
</c:forEach>

<hr>
<h2>Panier : </h2>
<jsp:include page="/controller?section=affichePanier" flush="true"/>
    <br>
    <c:url value="controller?section=jspPanier" var="url03" />
<a href="${url03}"><input type="submit" value="Valider Panier !" name="jspPanier" /></a>
