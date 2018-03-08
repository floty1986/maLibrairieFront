<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="obj.Adresse"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Livraison!</h1>
        <c:forEach items="${tables}" var="c" >
            <h3>${c}</h3>
            <ul>
                <c:forEach items="${mapExpediteur.get(c)}" var="p">
                    <input type="radio" name="${p}" value="${p}" /> ${p}
                </c:forEach>
            </ul>
        </c:forEach>
        <br>

        <div class="test">                      
            <table border="1">
                <td><h4>MON PANIER</h4></td>
                <c:forEach items="${voirPanier}" var="p">
                    <tr>                 
                        <td>${p.titre}</td>                  
                    </tr>
                </c:forEach>
            </table>
        </div>

        <br>
        <table border="0">

            <tr><td> <h4>Adresse de facturation : <h4/></td>
            <br>
            <br>
            <td>
                <c:forEach items="${listeAdresseF}" var="p">
                    ${p.nom} ${p.prenom} <br>
                    ${p.numVoie} ${p.typeVoie} ${p.nomVoie} <br>
                    ${p.complement} <br>
                    ${p.codePostal} ${p.ville}, ${p.pays}
                </td>
            </c:forEach></tr>

    </table>
    <br/>
    <table border="0" >
        <tr><td> <h4>Adresse de Livraison : <h4/></td>
        <br>
        <br>
        <td> 
            <c:forEach items="${listeAdresseL}" var="p">
                ${p.nom} ${p.prenom} <br>
                ${p.numVoie} ${p.typeVoie} ${p.nomVoie} <br>
                ${p.complement} <br>
                ${p.codePostal} ${p.ville}, ${p.pays} 
            </td>
        </c:forEach>
    </tr>

</table>
<a href="controller?section=jspCreerNvxCompteClientEtape2">changer<a/> <br/>

    <br/>
    <br/>
    <c:url value="controller?section=jspPanier" var="url06" />
    <a href="${url06}"><input type="submit" value="PRECEDENT" name="validLivraison" /></a>
    <br>
    <c:url value="controller?section=jspPaiement" var="url04" />
    <a href="${url04}"><input type="submit" value="VALIDER MA LIVRAISON" name="validLivraison" /></a>
</body>
</html>
