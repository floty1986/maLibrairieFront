
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UNE ADFRESSE DE FACTURATION</title>
    </head>
    <body>
        <h1>Entrez une adresse de facturation</h1>
    
        <form action="controller?section=....." method="POST">
            Nom:<input type="text" name="nom" value="" /><br>
            <br>
            Prenom:<input type="text" name="prenom" value="" /><br>
            <br>
            E-mail:<input type="text" name="email" value="" /><br>
            <br>
            Numero de voie:<input type="text" name="numVoie" value="" /><br>
            <br>
            Type de voie:<input type="text" name="typeVoie" value="" /><br>
            <br>
            Nom de la voie:<input type="text" name="nomVoie" value="" /><br>
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
