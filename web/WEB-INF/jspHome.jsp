<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>        
    </head>
    <body>
        <h1> Ma librairie </h1>
        <nav>
            <c:url value="controller?section=panier" var="url02" />
            <a href="${url02}"><input type="submit" value="Catalogue" name="afficheCatalogue" /></a>
           
            
            <c:url value="controller?section=login" var="url01" />                                    
            <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" /></a>
            
        </nav>
        
    </body>
</html>
