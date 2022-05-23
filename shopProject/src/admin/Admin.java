/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author taimoor
 */
public class Admin {
    public static String username;
    public static boolean isLogedin=false;
    
    
    public static void setUsername(String username)
    {
        Admin.username=username;
    }
    public static String getUsername()
    {
        return username;
    }
    
    public static void setIsLoggedIn(boolean isLogedin)
    {
        Admin.isLogedin=isLogedin;
    }
    
}
