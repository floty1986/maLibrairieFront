<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.beanPanier"%>
<%@page import="obj.Ouvrage"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier!</h1>


        <table border="1">
            <c:forEach items="${clefPanier}" var="p">
                <td><h4>${p}</h4></td>
            </c:forEach>
            <c:set var="total" scope="session" value="${0}"/>
            <c:forEach items="${voirPanier}" var="p">
                <tr>
                    <td>${p.idOuvrage}</td>                  
                    <td>${p.titre}</td>                   
                    <td>${p.qtePanier}</td>                   
                    <td>${p.prix}</td>  
                    <td>${p.qtePanier * p.prix}</td>
                    <c:set var="total" value="${total + (p.prix * p.qtePanier)}" />
                </tr>
            </c:forEach> 
            <tr>  
                <td>Total</td>
                <td><c:out value="${total}"/></td>
            </tr>
        </table>

        <c:url value="controller?section=jspLivraison" var="url03" />
        <a href="${url03}"><input type="submit" value="VALIDER MON PANIER" name="validPanier" /></a>
        
        <c:url value="controller?section=jspHome" var="url04" />
        <a href="${url04}"><input type="submit" value="ACCUEIL" name="home" /></a>
        
    </body>
</html>

