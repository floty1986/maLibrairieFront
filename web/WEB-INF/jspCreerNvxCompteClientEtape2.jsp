
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UN NOUVEAU COMPTE CLIENT ETAPE 2</title>
    </head>
    <body>
        <h1>Entrer une nouvelle adresse de livraison</h1>
    
        <form action="controller?section=....." method="POST">
        
            Nom:<input type="text" name="nom" value="" /><br>
            <br>
            Prenom:<input type="text" name="prenom" value="" /><br>
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
            Numero de téléphone:<input type="text" name="numTel" value="" /><br>
            <br>
            Complément d'adresse:<input type="text" name="complAdr" value="" /><br>
            <br>
            Cette adresse est-elle également votre adresse de facturation?<br>
            <br>
            Oui:<input type="radio" name="adrFacturation" value="oui" /><br>
            Non:<input type="radio" name="adrFacturation" value="non" /><br>
            <br>
            <input type="submit" value="Continuer" name="doIt" />
        
        
        </form>
    
    
    
    </body>
</html>
