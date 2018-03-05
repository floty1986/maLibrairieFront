<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Mes coordonnées</h1
            
        <p>Nom  <input type="text" name="nom" value='${infoClientNom}' />  </p>
        <p>Prénom  <input type="text" name="prenom" value='${infoClientPrenom}' /> </p>
        <p>Genre  <input type="text" name="genre" value='${infoClientGenre}' /> </p>
        <p>Date de Naissance <input type="text" name="dateNaissance" value='${infoClientDateNaissance}' /> </p>
        <p>E-mail  <input type="text" name="email" value='${infoClientEmail}' /> </p>
        <p>telephone  <input type="text" name="telephone" value='${infoClientEmail}' /> </p>
        <p>Mot de passe  <input type="text" name="motDePasse" value='${infoClientMotDePasse}' /> </p>
        
        <p><input type="submit" value="Modifier" /> </p>
        
        
        
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
        
        
    </body>
</html>
