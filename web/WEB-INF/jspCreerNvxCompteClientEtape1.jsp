<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UN NOUVEAU COMPTE CLIENT ETAPE 1</title>
    </head>
    <body>
        <h1>Créer un compte</h1>


        <!-- <form action="controller?section=jspCreerNvxCompteClientEtape2" method="POST"> -->
        <form action="controller" method="get">
            <input type="hidden" name="section" value="jspCreerNvxCompteClientEtape2" />
            Votre nom: <input type="text" name="nom" value="" /><br>
            <br>
            Votre prenom: <input type="text" name="prenom" value="" /><br>
            <br>
            Genre: M<input type="radio" name="genre" value="M" />F<input type="radio" name="genre" value="F" />N<input type="radio" name="genre" value="N" /><br>
            <br>            
            date de naissance:<input type="text" name="dateNaissance" value="" /><br>
            <br>
            E-mail: <input type="text" name="email" value="" /><br>
            <br>
            Telephone: <input type="text" name="telephone" value="" /><br>
            <br>
            Mot de Passe: <input type="text" name="motDePasse" value="" /><br>
            <br>
            Entrer le mot de passe à nouveau: <input type="text" name="motDePasseConf" value="" /><br>            
            <br>
            <p>En créant votre compte, vous acceptez l'intégralité de<br>
               nos conditions générales de vente, notre politique de<br>
               gestion de vos informations personnelles et notre <br>
               politique cookies et publicité sur internet.
            </p><br>
            <br>
            <input type="submit" value="Créer votre compte" name="NvxCompte1" />
        </form>
        <br>
        <form action="controller?section=login" method="POST">

        </form>

        <c:url value="controller?section=login" var="url01"/>
        Vous possédez déjà un compte?:<a href="${url01}"><input type="submit" value="Identifiez-vous ici" name="login" /></a>
            

    </body>
</html>
