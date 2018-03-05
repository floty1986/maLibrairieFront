<%@page import="obj.Ouvrage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>catalogueTitre</title>
    </head>
    <body>
        <h1>Titre(s) trouvé(s) :</h1>
        <c:forEach items="${titres}" var="t">
                    <li>
                        
                        <a href='controller?section=panier&add=${t.idOuvrage}&add2=${t.titre}'>ID : ${t.idOuvrage}, Titre : ${t.titre}</a>
                    </li>
                </c:forEach>
    </body>
</html>
