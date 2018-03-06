<%@page import="obj.Adresse"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
            Date de Naissance : <input type="text" name="dateNaissance" value='${infoClientDateNaissance}' />
            <br>
            <br>
            E-mail : <input type="text" name="email" value='${infoClientEmail}' />
            <br>
            <br>
            telephone : <input type="text" name="telephone" value='${infoClientEmail}' />
            <br>
            <br>
            Mot de passe : <input type="text" name="motDePasse" value='${infoClientMotDePasse}' />
            <br>
            <br>
            <input type='submit' name='modifierCl' value='Modifier' />
        </form>

        <h1>Mes Adresses</h1>

        <form action='controller' method='post'>
            <h2>Adresse de facturation<h2/>

                <c:forEach items="${listeAdresseF}" var="p">
                    <li>
                        ${p.nom}, ${p.prenom}
                        ${p.numVoie}, ${p.typeVoie}, ${p.nomVoie}
                        ${p.complement}
                        ${p.codePostal}, ${p.ville}, ${p.pays}
                    </li>
                </c:forEach>

            <h2>Adresse de Livraison<h2/>

                <c:forEach items="${listeAdresseL}" var="p">
                    <li>
                        ${p.nom}, ${p.prenom}
                        ${p.numVoie}, ${p.typeVoie}, ${p.nomVoie}
                        ${p.complement}
                        ${p.codePostal}, ${p.ville}, ${p.pays}
                    </li>
                </c:forEach>
 

            <input type='submit' name='modifierAdr' value='Modifier' />
        </form>






        </body>
</html>
