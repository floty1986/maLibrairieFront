<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue-Panier</title>
    </head>
    <body>
        <jsp:include page="/controller?section=catalogue" flush="true"/>
        <hr>   
        <div class="footer">
            <h4>Panier : </h4>
            <jsp:include page="/controller?section=affichePanier" flush="true" />
            <c:url value="controller?section=jspPanier" var="url03" />
            <a href="${url03}">Valider panier</a>
            <hr>
            <c:url value="controller?section=login" var="url01" />                                    
            <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>
            <a href = 'controller?section=jspPanier'><input type="submit" value="Voir Panier !" name="voirPanier" /></a>
        </div>
    </body>
</html>
