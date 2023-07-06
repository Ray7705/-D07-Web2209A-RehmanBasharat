/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.preferences.Controller;

import basharat.preferences.Model.Preferences;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author rehma
 */
@WebServlet(name = "PreferencesController" , urlPatterns = {"/Preferences"})
public class PreferencesController extends HttpServlet {
    private static final String NAME_COOKIE = "name";
    private static final String COLOR_COOKIE = "color";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String name = null;
        String color = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    name = cookie.getValue();
                } else if (cookie.getName().equals("color")) {
                    color = cookie.getValue();
                }
            }
        }

    Preferences userPreferences = new Preferences();
    userPreferences.setName(name);
    userPreferences.setColor(color);

    // Set UserPreferences object as an attribute
    request.setAttribute("userPreferences", userPreferences);

    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
    dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        boolean remember = request.getParameter("remember") != null;

        
        Preferences userPreferences = new Preferences();
        userPreferences.setName(name);
        userPreferences.setColor(color);
        userPreferences.setRemember(remember);


        
        if (remember) {
            Cookie nameCookie = new Cookie("name", name);
            response.addCookie(nameCookie);

            Cookie colorCookie = new Cookie("color", color);
            response.addCookie(colorCookie);
        } else {
            Cookie nameCookie = new Cookie("name", "");
            nameCookie.setMaxAge(0);
            response.addCookie(nameCookie);

            Cookie colorCookie = new Cookie("color", "");
            colorCookie.setMaxAge(0);
            response.addCookie(colorCookie);
        }
        
        request.setAttribute("Preferences", userPreferences);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
    
    


}
