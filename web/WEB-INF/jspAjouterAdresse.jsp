<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJOUTER ADRESSE</title>
    </head>
    <body>
        <h1>Entrer une adresse pour ${nom} </h1>
    
        <form action="controller?section=ajouterAdresse" method="POST">
                    
            <hr>
            LIVRAISON:<input type="radio" name="typeAdresse" value="LIVRAISON" /><br>
            FACTURATION:<input type="radio" name="typeAdresse" value="FACTURATION" /><br>
            <hr>
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
            <input type="submit" value="Ajouter" name="ajout" />      
        </form>
    
    </body>
</html>
