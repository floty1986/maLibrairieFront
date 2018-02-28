<%@page import="obj.Ouvrage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
        <h1>CATALOGUE</h1>
       

         <c:forEach items="${clefs}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${mapOuvrages.get(c)}" var="p">
                    <li>
                        <a href='catalog.jsp?add="${p}"'>${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
            <hr>
            <h2>PANIER :</h2>
            <jsp:useBean class="beans.beanPanier" scope="session" id="monPanier" />
        <%
            if (request.getParameter("add") != null) {
                monPanier.add(request.getParameter("add"));
            }
            if (request.getParameter("dec") != null) {
                monPanier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                monPanier.del(request.getParameter("del"));
            }
            if (request.getParameter("clear") != null) {
                monPanier.clear();
            }
        %>   
        <% if (monPanier.isEmpty()) { %>
        Panier vide !        
        <% } else {
            for (Ouvrage o : monPanier.listO()) {%>
        <%=o.getIdOuvrage()%>/<%=o.getTitre()%>
        <a href='catalogue.jsp?add=<%=o.getIdOuvrage()%>'>+</a>
        <a href='catalogue.jsp?dec=<%=o.getIdOuvrage()%>'>-</a>
        <a href='catalogue.jsp?del=<%=o.getIdOuvrage()%>'>X</a>
        <br>
        <% } %>
        <a href='jspPanier.jsp?clear'>Vider le panier !</a>        
        <% }%>

    </body>
</html>
