<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <style>
                    body
                    {background-color: silver;
                    text-align: center
                    }
                </style>
        <title>AJOUTER ADRESSE</title>
    </head>
    <body>
        <h1>Entrer une adresse pour ${nom} </h1>
    
        <form action="controller?section=ajouterAdresse" method="POST">
                    
            <hr>
            LIVRAISON :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="typeAdresse" value="LIVRAISON" /><br>
            FACTURATION :<input type="radio" name="typeAdresse" value="FACTURATION" /><br>
            <hr>
            Nom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="nom" value="" /><br>
            <br>
            Prenom :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="prenom" value="" /><br>
            <br>
            E-mail :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" value="" /><br>
            <br>
            Numero de voie :&nbsp;<input type="text" name="numVoie" value="" /><br>
            <br>
            Type de voie :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="typeVoie" value="" /><br>
            <br>
            Nom de la voie :&nbsp;&nbsp;<input type="text" name="nomVoie" value="" /><br>
            <br>
            ville :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ville" value="" /><br>
            <br>           
            Code postal :&nbsp;&nbsp;&nbsp;<input type="text" name="codePostal" value="" /><br>
            <br>
            Pays :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="pays" value="" /><br>
            <br>
            Telephone :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="telephone" value="${telephone}" /><br>
            <br>
            Complément d'adresse :&nbsp;<input type="text" name="complement" value="" /><br>
            <br>           
            <input type="submit" value="Ajouter" name="ajout" />      
        </form>
    
    </body>
</html>
