<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Panier!</h1>
        <jsp:include page="controller?section=panier" flush="true" />
       

      
            <c:forEach var="i" items="${list}">
                ${i.ref}/${i.qty}
                <a href="controller?section=panier&add=${i.ref}">+</a>
                <a href="controller?section=panier&dec=${i.ref}">-</a>
                <a href="controller?section=panier&del=${i.ref}">x</a>
                <br>        
            </c:forEach>
            <a href='controller?section=panier&clear'>Vider le panier !</a>         
        
    </body>
</html>
