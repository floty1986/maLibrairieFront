
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONNEXION</title>
    </head>
    <body>
        <h1>Hello Login!</h1>
        
        <form action='controller' method='post'>
            Utilisateur : <input type='text' name='login' /><br>
            <br>            
            Mot de passe : <input type='password' name='password' /><br>
            <input type='submit' name='doIt' value='Ok' />
        </form>
          
        
    </body>
</html>
