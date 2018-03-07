<%@page import="obj.Commande"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historique de commandes</title>
    </head>
    <body                        
        <h1>Historique des Commande de ${nom}<h1/>

            <c:forEach items="${listeCommande}" var="p">
                <p class="small">
                    numéro de commande : <a href="controller?section=historiqueCommande&numCommande=${p.numCommande}">${p.numCommande}</a><br/> 
                    date de la commande : ${p.dateCommande}<br/>
                    <br/>
                <p/>                
            </c:forEach>

            <c:if test="${affLC}">
                <hr>
                <h3>Historique des lignes de Commande de la commande numero ${p.numCommande}<h3/>
                    <c:forEach items="${listeLigneCommande}" var="p">
                        <p class="small">
                            ref ouvrage : ${p.idOuvrage}<br/>
                            prix        : ${p.prix}<br/>
                            Qt commandé : ${qteCommandee}<br/>
                            remise      : ${p.remise}<br/>
                            tva         : ${tvaLC}
                            <br/>
                        <p/>                
                    </c:forEach>
                    <hr>

                </c:if>         

    </body>
</html>
