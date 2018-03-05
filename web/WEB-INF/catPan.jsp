<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue-Panier</title>
    </head>
    <body>
        <h1>CATALOGUE</h1>
        <jsp:include page="/controller?section=catalogue" flush="true"/>
        <hr>       
        <h2>PANIER</h2>
        <jsp:include page="/controller?section=affichePanier" flush="true" />
        <hr>
        <!--<a href='controller?section=jspCreerNvxCompteClientEtape1'>Creer nouveau compte</a> -->
        <c:url value="controller?section=login" var="url01" />  
        
        <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>

        <c:url value="controller?section=jspCreerNvxCompteClientEtape1" var="url01"/>
        <a href="${url01}"><input type="submit" value="Créer un nouveau compte client" name="NvxCompte1" /></a>

        <c:url value="controller?section=jspCreerNvxCompteClientEtape2" var="url02"/>
        <a href="${url02}"><input type="submit" value="Poursuivre la création de votre compte" name="NvxCompte2" /></a>
        

    </body>
</html>
