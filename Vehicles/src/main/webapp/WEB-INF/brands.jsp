<%-- 
    Document   : brands
    Created on : Jun 17, 2023, 8:35:57 PM
    Author     : rehma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Brand> brands = (ArrayList<Brand>) request.getAttribute("brands");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <% for (Brand brand : brands) { %>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <% } %>


            </tbody>
        </table>
    </body>
</html>
