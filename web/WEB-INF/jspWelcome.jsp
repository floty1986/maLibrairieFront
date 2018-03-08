<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compte client</title>
    </head>
    
    <body>
        <h1>Welcome ${welcome}!</h1>
        <hr>        
        <a href='controller?deconnect'><input type='submit' name='deconnecter' value='Deconnexion' /></a>
        <br>
        <hr>
        <a href='controller?section=afficher-client'><input type='submit' name='profilClient' value='profil de ${welcome}' /></a>        
        <a href='controller?section=historiqueCommande'><input type='submit' name='historiqueCommande' value='Historique de commande de ${welcome}' /></a><br/>
        <hr>        
        <jsp:include page="/controller?section=catalogue" flush="true"/>
        <hr>       
        <h2>VOTRE PANIER</h2>
        <jsp:include page="/controller?section=affichePanier" flush="true" />
        
    </body>
</html>
