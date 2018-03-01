<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Livraison!</h1>
        <c:forEach items="${tables}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapExpediteur.get(c)}" var="p">
                    <li>
                        <a href="#">${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
        <a href="jspPanier.jsp">Précédent</a>
        <br>
        <c:url value="controller?section=jspPaiement" var="url04" />
        <a href="${url04}">Confirmer la livraison</a>
    </body>
</html>
