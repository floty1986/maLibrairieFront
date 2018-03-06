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
                <c:forEach items="${voirPanier}" var="p">
                    <table border="2">
                        <tbody>
                            <tr>
                                <td>${p}</td>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>
        </c:forEach>
        <c:url value="controller?section=jspLivraison" var="url03" />
        <a href="${url03}">Valider panier</a>
        
        
        
        
        

    </body>
</html>
