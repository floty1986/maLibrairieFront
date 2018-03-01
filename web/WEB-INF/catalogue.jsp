<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
        <h1>CATALOGUE</h1>
       

         <c:forEach items="${clefs}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapOuvrages.get(c)}" var="p">
                    <li>
                        <a href="#">${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
      <!-- <div class="vr_catalogue">PANIER EN CONSTRUCTION....</div> -->
       <nav> 
       <c:url value="controller?section=jspPanier" var="url55" />
       <a href="${url55}">Voir panier</a>
       </nav>
       
       
    </body>
</html>
