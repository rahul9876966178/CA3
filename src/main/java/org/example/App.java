package org.example;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App {
    public boolean login_test(String uname, String pass) {
        ResourceBundle r = ResourceBundle.getBundle("config");
        String username = r.getString("username");
        String password = r.getString("password");

        if (username.equals(uname) && password.equals(pass)) {
            return true;
        }
        // public static void main( String[] args )
        //{
        //  System.out.println( "Hello World!" );
        // }
        else {
            return false;
        }
    }
}