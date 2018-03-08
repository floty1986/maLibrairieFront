<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.beanPanier"%>
<%@page import="obj.Ouvrage"%>

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
                <td><h1>${p}</h1></td>
            </c:forEach>
            <c:forEach items="${voirPanier}" var="p">
                <tr>
                <td>${p.idOuvrage}</td>                  
                <td>${p.titre}</td>                   
                <td>${p.qtePanier}</td>                   
                <td>${p.prix}</td>                   
                </tr>
            </c:forEach>
        </table>
            
    <c:url value="controller?section=jspLivraison" var="url03" />
    <a href="${url03}"><input type="submit" value="VALIDER MON PANIER" name="validPanier" /></a>

</body>
</html>

