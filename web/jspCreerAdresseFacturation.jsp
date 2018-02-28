
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UNE ADFRESSE DE FACTURATION</title>
    </head>
    <body>
        <h1>Entrez une adresse de facturation</h1>
    
        <form action="controller" method="POST">
            Nom:<input type="text" name="nom" value="" /><br>
            <br>
            Prenom:<input type="text" name="prenom" value="" /><br>
            <br>
            Adresse ligne1:<input type="text" name="adresseLigne1" value="" /><br>
            <br>
            Adrdesse ligne 2:<input type="text" name="adresseLigne2" value="" /><br>
            <br>
            Ville:<input type="text" name="ville" value="" /><br>
            <br>
            Etat/Region/Canton (si approprié):<input type="text" name="etatRegionCanton" value="" /><br>
            <br>
            Code postal:<input type="text" name="codePostal" value="" /><br>
            <br>
            Pays ou DOM-TOM:<input type="text" name="paysDomTom" value="" /><br>
            <br>
            Numero de téléphone:<input type="text" name="numTel" value="" /><br>
            <br>
            Complément adresse:<input type="text" name="complAdr" value="" /><br>
            <br>
        <input type="submit" value="Livrer à cette adresse" name="doIt" />
        </form>
    
    
    
    
    
    </body>
</html>
