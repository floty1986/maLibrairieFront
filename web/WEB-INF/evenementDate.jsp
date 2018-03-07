<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<c:forEach var="e" items="${evenements}">
    <li> 
       Numéro Evénement : ${e.idEvenement} *** Nom : ${e.nom} *** Date de Fin : ${e.dateFin} 
    </li>
    <br>        
</c:forEach>
