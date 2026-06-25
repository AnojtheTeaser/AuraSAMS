/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

/**
 *
 * @author TechWave
 */
public class UserSession {
    
    // concept is mine and use AI Support to do some developments
    
       private static String loggedInUser;
    private static String userRole;

    public static void createSession(String username) {
        loggedInUser = username;

        if (username.toUpperCase().startsWith("ADM")) {
            userRole = "ADMIN";
        } else if (username.toUpperCase().startsWith("LEC")) {
            userRole = "LECTURER";
        } else {
            userRole = "UNKNOWN";
        }
    }

    public static void clearSession() {
        loggedInUser = null;
        userRole = null;
    }

    public static String getLoggedInUser() { return loggedInUser; }
    public static String getUserRole() { return userRole; }
    
    
    
}
