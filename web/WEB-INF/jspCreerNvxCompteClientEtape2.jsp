
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UN NOUVEAU COMPTE CLIENT ETAPE 2</title>
    </head>
    <body>
        <h1>Entrer une nouvelle adresse de livraison</h1>
    
        <form action="controller" method="POST">
        
            Nom:<input type="text" name="nom" value="" /><br>
            <br>
            Prenom:<input type="text" name="prenom" value="" /><br>
            <br>
            Adresse ligne 1:<input type="text" name="adresseLigne1" value="" /><br>
            <br>
            Adresse ligne 2:<input type="text" name="adresseLigne1" value="" /><br>
            <br>
            ville: <input type="text" name="ville" value="" /><br>
            <br>
            Etat/Region/Canton (si approprié):<input type="text" name="etatRegionCanton" value="" /><br>
            <br>
            Code postal:<input type="text" name="codePostal" value="" /><br>
            <br>
            Pays ou DOM-TOM:<input type="text" name="paysDomTom" value="" /><br>
            <br>
            Numero de téléphone:<input type="text" name="numTel" value="" /><br>
            <br>
            Complément d'adresse:<input type="text" name="complAdr" value="" /><br>
            <br>
            Cette adresse est-elle également votre adresse de facturation?<br>
            <br>
            <input type="radio" name="adrFacturation" value="Oui" /><br>
            <input type="radio" name="adrFacturation" value="Non" /><br>
            <br>
            <input type="submit" value="Continuer" name="doIt" />
        
        
        </form>
    
    
    
    </body>
</html>
