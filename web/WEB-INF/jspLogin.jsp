

    <body>
        <h1>Hello Login!</h1>
        
        <form action='controller' method='post'>
            Utilisateur : <input type='text' name='login' value='${login}' /><br>
            <br>            
            Mot de passe : <input type='password' name='password' /><br>
            <input type='submit' name='doIt' value='Ok' />
        </form>
        <font color='red'>${msg}</font>  
        
    </body>
</html>
