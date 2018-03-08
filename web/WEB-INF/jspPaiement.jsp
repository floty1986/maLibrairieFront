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
        <h1>Hello Paiement!</h1>
         <c:forEach items="${tables}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapOrganisme.get(c)}" var="p">
                    <input type="radio" name="${p}" value="${p}" /> ${p}
                </c:forEach>
            </ul>
        </c:forEach>
        <c:url value="controller?section=jspLivraison" var="url05" />
        <a href="${url05}"><input type="submit" value="PRECEDENT" name="retourPaie" /></a>
        <a href="http://www.paypal.com"><input type="submit" value="VALIDER PAIEMENT" name="validPaie" /></a>
        
        <c:url value="controller?section=jspCreerAdresseFacturation" var="url01"/>
        <a href="${url02}"><input type="submit" value="Créer une adresse de facturation" name="AdresseFacturation" /></a>
        
    </body>
</html>
