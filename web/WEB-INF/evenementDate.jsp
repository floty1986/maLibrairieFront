<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:forEach var="e" items="${evenements}">
        ${e.idEvenement} / ${e.nom} / ${e.dateFin} 

        <br>        
    </c:forEach>
