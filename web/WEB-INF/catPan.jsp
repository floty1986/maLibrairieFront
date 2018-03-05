
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue-Panier</title>
    </head>
    <body>
        <h1>CATALOGUE</h1>
        <jsp:include page="/controller?section=catalogueAccueil" flush="true"/>
        <hr>       
        <h2>PANIER</h2>
        <jsp:include page="/controller?section=affichePanier" flush="true" />
        <a href = 'controller?section=jspPanier'><input type="submit" value="Voir Panier !" name="voirPanier" /></a>
    </body>
</html>
