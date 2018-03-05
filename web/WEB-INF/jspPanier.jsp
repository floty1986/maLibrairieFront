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
        
        ${voirPanier}
        
        
        <c:forEach items="${clefs}" var="c" >
            <h1>${c}</h1>
            <ul>
                <c:forEach items="${voirPanier}" var="p">
                    <li>
                        <a href="#">${p}</a>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>

    </body>
</html>
