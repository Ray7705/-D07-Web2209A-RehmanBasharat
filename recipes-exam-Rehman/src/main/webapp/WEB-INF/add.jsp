<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ca.collegeuniversel.recipes.entities.RecipeCategory"%>
<%@page import="java.util.ArrayList"%>
<%
    String errorMessage = (String) request.getAttribute("error-message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Add Recipe</title>
    </head>
    <body>
        <form action="add" method="post" class="main-form">
            <fieldset>
                <legend>Add Recipe</legend>
                <label>Name</label>
                <input type="text" name="name" required>

                <label>Description</label>
                <input type="text" name="description" required>

                <label>Image Path</label>
                <input type="text" name="image_path" required>

                <label>Category Id</label>
                <input type="text" name="category_id" required>

                <% if (errorMessage != null ) { %>
                <%="<p class='error'>"+errorMessage+"</p>"%>

                <% } %>

                <button type="submit">Add</button>
            </fieldset>
        </form>
    </body>
</html>
