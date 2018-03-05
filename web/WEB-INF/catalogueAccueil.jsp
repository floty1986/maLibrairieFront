<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="/maLibrairieFront/css/maLibrairieCSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil Catalogue</title>
    </head>
    <body>
        <h1>Afficher le Catalogue</h1>
        Souhaitez-vous afficher le catalogue dans son <a href="controller?section=catalogue">intégralité</a>
        <br>
        ou uniquement le titre recherché?
        <br>
         <form action="controller?section=catalogueTitre" method="POST">
        <input type="text" name="titreRecherche" value="titre recherché" />
        <input type="submit" value="Chercher" name="chercherTitre" />
         </form>
        
    </body>
</html>
