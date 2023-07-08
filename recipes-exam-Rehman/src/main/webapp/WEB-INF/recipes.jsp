<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ca.collegeuniversel.recipes.entities.User"%>
<%
    User name = (User) request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipes</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body class="container vertical">
        <h1>Welcome <%= name.getName() %></h1>
        <button type=logout>Log Out</button>
        <button type="add">Add Recipe</button>
        
        <div>
            <fieldset>
                <legend>Likes</legend>
                
                
            </fieldset>
        </div>
    </body>
</html>
