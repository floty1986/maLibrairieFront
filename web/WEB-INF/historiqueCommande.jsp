<%@page import="obj.Commande"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historique de commandes</title>
    </head>
    <body                        
        <h1>Historique des Commande de ${nom}<h1/>

            <c:forEach items="${listeCommande}" var="p">
                <p class="small">
                    numéro de commande : ${p.numCommande}<br/> 
                    date de la commande : ${p.dateCommande}<br/>
                    <br/>
                <p/>                
            </c:forEach>

    </body>
</html>
