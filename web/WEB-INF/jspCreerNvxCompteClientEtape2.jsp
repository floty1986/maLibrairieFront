<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UN NOUVEAU COMPTE CLIENT ETAPE 2</title>
    </head>
    <body>
        <h1>Entrer une adresse de livraison</h1>
        <p>Lorsque vous aurez terminé, cliquez sur le bouton "Continuer" </p>
    
        <form action="controller" method="POST">
                    <input type="hidden" name="section" value="jspCreerNvxCompteClientEtape3" />

            Nom:<input type="text" name="nom" value="${nom}" /><br>
            <br>
            Prenom:<input type="text" name="prenom" value="${prenom}" /><br>
            <br>
            E-mail:<input type="text" name="email" value="${email}" /> <br>
             <br>
            Numero de voie:<input type="text" name="numVoie" value="" /><br>
            <br>
            Type de voie:<input type="text" name="typeVoie" value="" /><br>
            <br>
            Nom de la voie:<input type="text" name="nomVoie" value="" /><br>
            <br>
            ville: <input type="text" name="ville" value="" /><br>
            <br>           
            Code postal:<input type="text" name="codePostal" value="" /><br>
            <br>
            Pays:<input type="text" name="pays" value="" /><br>
            <br>
            Telephone:<input type="text" name="telephone" value="${telephone}" /><br>
            <br>
            Complément d'adresse:<input type="text" name="complement" value="" /><br>
            <br>           
            <input type="submit" value="Continuer" name="NvxCompte2" />      
        </form>
            
             Cette adresse est-elle également votre adresse de facturation?<br>
            <br>
            Oui:<input type="radio" name="adrFacturation" value="oui" /><br>
            Non:<input type="radio" name="adrFacturation" value="non" /><br>
            <br>
       
    
    </body>
</html>
