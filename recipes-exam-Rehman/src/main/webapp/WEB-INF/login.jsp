<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String errorMessage = (String) request.getAttribute("error-message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Log in</title>
    </head>
    <body>
        <form action="add" method="post" class="login-form">
            <fieldset>
                <legend>Log In</legend>
                <label>UserName</label>
                <input type="text" name="username" required>

                <label>Password</label>
                <input type="password" name="password_hash" required>

                <% if (errorMessage != null ) { %>
                <%="<p class='error'>"+errorMessage+"</p>"%>

                <% } %>

                <button type="submit">LogIn</button>
            </fieldset>
        </form>

    </body>
</html>
