<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>        
    </head>
    <body>
        <h1> MaLibrairie </h1>
        <p><img src='images/lello3.jpg' alt='lello'/></p>
        <hr>
        <nav>
            <c:url value="controller?section=panierA" var="url02" />
            <a href="${url02}"><input type="submit" value="Catalogue" name="afficheCatalogue" class="btn_cat2"/></a>
            <br>
            <hr>
            <c:url value="controller?section=evenement" var="url03" />                                    
            <a href="${url03}"><input type="submit" value="Evénements" name="Connexion" class="btn_eve"/></a>
              <hr>
            <br>            
             <c:url value="controller?section=login" var="url01" />                                    
            <a href="${url01}"><input type="submit" value="LOGIN" name="Connexion" class="btn_login"/></a>
          
            
        </nav>
        
    </body>
</html>
