<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="centre">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONNEXION</title>
    </head>
    <body>
        <h1>Hello Login!</h1>
        
        <form action='controller?section=login' method='post'>
            Utilisateur : <input type='text' name='login' value='${login}' /><br>
            <br>            
            Mot de passe : <input type='password' name='password' /><br>
            <input type='submit' name='doIt' value='Ok' />
        </form>
        <font color='red'>${msg}</font>  
        
        <br>
        <c:url value="controller?section=jspCreerNvxCompteClientEtape1" var="url01"/>
        <a href="${url01}"><input type="submit" value="Créer un nouveau compte client" name="NvxCompte1" /></a>
            
    </body>
</html>
