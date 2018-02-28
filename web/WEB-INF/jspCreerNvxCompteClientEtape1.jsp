
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREER UN NOUVEAU COMPTE CLIENT ETAPE 1</title>
    </head>
    <body>
        <h1>Créer un compte</h1>
        
        <form action="controller?section=jspCreerNvxCompteClientEtape2" method="POST">
            Votre nom: <input type="text" name="nom" value="" /><br>
            <br>
            Votre prenom: <input type="text" name="prenom" value="" /><br>
            <br>
            Genre: H<input type="radio" name="genre" value="H" />F<input type="radio" name="genre" value="F" />N<input type="radio" name="genre" value="N" /><br>
            <br>            
            date de naissance:<input type="text" name="dateNaissance" value="" /><br>
            <br>
            E-mail: <input type="text" name="email" value="" /><br>
            <br>
            Mot de Passe: <input type="text" name="motDePasse" value="" /><br>
            <br>
            Entrer le mot de passe à nouveau: <input type="text" name="motDePasseConf" value="" /><br>
            <br>
            <input type="submit" value="Créer votre compte" name="doIt1" /><br>
            <br>
            
            En créant votre compte, vous acceptez bla, bla, bla,....<br>
            <br>
            
            Vous possédez dèjà un compte?
            <input type="submit" value="Identifiez-vous ici" name="doIt" />
        </form>
        
        
        
        
    </body>
</html>
