<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>evenements</title>
    </head>
    <body>
        <h1>LES EVENEMENTS</h1>
        <hr>
        <br>
        <h3>Voici les événements en cours ou à venir :</h3>
        <br>
        <hr>
        <c:url value="controller?section=evenementDate" var="url04" />
        <c:import url="${url04}" />
    </body>
</html>
