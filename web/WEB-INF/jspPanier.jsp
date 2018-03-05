<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier!</h1>
        <c:forEach items="${clefs}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapPanier.get(c)}" var="p">
                    <li>
                        <a href="#">${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
         
        <c:if test="${panierVide}">
            Panier vide !
           
        </c:if>
        <c:forEach var="i" items="${list}">
            ${i.ref}/${i.qty}
            <a href="controller?section=panier&add=${i.ref}">+</a>
            <a href="controller?section=panier&dec=${i.ref}">-</a>
            <a href="controller?section=panier&del=${i.ref}">x</a>
            <br>        
        </c:forEach>
        
        <a href="controller?section=panier&clear"><input type="submit" value="Vider le panier !" name="vider" /></a><br>          
        <c:url value="controller?section=jspLivraison" var="url03" />
        <a href="${url03}"><input type="submit" value="Valider le panier !" name="valider" /></a>
        <br>
        
    </body>
</html>
