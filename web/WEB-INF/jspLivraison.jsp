<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
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
                    <input type="radio" name="${p}" value="${p}" /> ${p}
                </c:forEach>
            </ul>
        </c:forEach>
         <c:url value="controller?section=jspLivraison" var="url06" />
        <a href="${url06}">Précédent</a>
        <br>
        <c:url value="controller?section=jspPaiement" var="url04" />
        <a href="${url04}">Confirmer la livraison</a>
    </body>
</html>
