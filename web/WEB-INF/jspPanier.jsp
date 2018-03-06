<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="obj.Adresse"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier!</h1>

        ${voirPanier}

        <table border="2">
            <thead>
                <tr>
                    <td><h1>${clefs}</h1></td>
                </tr>
            </thead>
            <c:forEach items="${voirPanier}" var="p">
                <tbody>
                    <tr>
                        <td>${p}</td>
                    </tr>
                </tbody>
            </table>
        </c:forEach>


        <br>

        ${infoClientNom}
        ${infoClientPrenom}

        <br>

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


                <c:url value="controller?section=jspLivraison" var="url03" />
                <a href="${url03}"><input type="submit" value="Valider Panier !" name="validPanier" /></a>

                </body>
                </html>
