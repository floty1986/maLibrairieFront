<%@page import="obj.Adresse"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Mes coordonnées</h1>

        <form action='controller' method='post'>
            Nom : <input type="text" name="nom" value='${infoClientNom}' />
            <br>
            <br>
            Prénom : <input type="text" name="prenom" value='${infoClientPrenom}' />
            <br>
            <br>
            Genre : <input type="text" name="genre" value='${infoClientGenre}' />
            <br>
            <br>
            Date de Naissance : <input type="text" name="dateNaissance" value='${infoClientDateNaissance}' /> format date jj-mm-aaaa
            <br>
            <br>
            E-mail : <input type="text" name="email" value='${infoClientEmail}' />
            <br>
            <br>
            telephone : <input type="text" name="telephone" value='${infoClientTelephone}' />
            <br>
            <br>
            Mot de passe : <input type="text" name="motDePasse" value='${infoClientMotDePasse}' />
            <br>
            <br>
            <input type='submit' name='modifierCl' value='Modifier' /><br/>
            <br>
            
            <input type="submit" value="Ajouter Une Adresse" name="ajouterAdresse" />
            
            
        </form>

        <h1>Mes Adresses</h1>

        
            <h2>Adresse de facturation<h2/>

                <c:forEach items="${listeAdresseF}" var="p">
                    <p class="small">
                        
                        ${p.nom}, ${p.prenom}<br/>
                        ${p.numVoie}, ${p.typeVoie} ${p.nomVoie}<br/>
                        ${p.complement}<br/>
                        ${p.codePostal}, ${p.ville}, ${p.pays}
                        <a href="controller?section=supprimerAdFact&idAdresse=${p.idAdresse}"><input type="submit" value="Supprimer" name="sup" /></a>
                    <p/>
                    <br/>
                </c:forEach>

            <h2>Adresse de Livraison<h2/>

                <c:forEach items="${listeAdresseL}" var="p">
                    <p>
                        
                        ${p.nom}, ${p.prenom}<br/>
                        ${p.numVoie}, ${p.typeVoie} ${p.nomVoie}<br/>
                        ${p.complement}<br/>
                        ${p.codePostal}, ${p.ville}, ${p.pays}
                        <a href="controller?section=supprimerAdLiv&idAdresse=${p.idAdresse}"><input type="submit" value="Supprimer" name="sup" /></a>
                    <p/>
                    <br/>
                </c:forEach>
           
      






        </body>
</html>
