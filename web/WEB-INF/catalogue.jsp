<%@page import="obj.Ouvrage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

         <c:forEach items="${clefs}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapOuvrages.get(c)}" var="p">
                    <li>
                        
                        <a href='controller?section=panier&add=${p.idOuvrage}&add2=${p.titre}'>${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
            <c:url value="controller?section=jspPanier" var="url03" />
        <a href="${url03}">Voir panier</a>
   
