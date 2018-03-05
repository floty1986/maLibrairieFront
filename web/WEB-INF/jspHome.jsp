<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>        
    </head>
    <body>
        <nav>
            <c:url value="controller?section=login" var="url01" />
            <c:import url="${url01}" />
            
            <c:url value="controller?section=catalogueAccueil" var="url02" />
            <a href="${url02}">Accueil Catalogue</a>
            
        </nav>
        
    </body>
</html>
