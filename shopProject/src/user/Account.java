
package user;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JLabel;
import java.io.FileWriter;

public class Account {
    
    public static void clearErrors(JLabel label1 , JLabel label2) {
        label1.setVisible(false);
        label2.setVisible(false);
    }
    
      // e1 is "empty fields" error and e2 is "already reigstered" error and they are JLabels
    public static void registerUser(String username , String password , JLabel e1 ,JLabel e2) {
        boolean cont = checkRegistrationCreds(username , password , e1 , e2);
        if (cont == true) { // if Fields are not empty and user is not already registered
            try {
                FileWriter usersFile = new FileWriter("database/users.txt" , true);
                usersFile.append(username.trim() + ":" + password.trim() + "\n");
                usersFile.close();
            } catch (IOException e) {
                System.out.println("something went wrong registring user to database: " + e);
            }
        }
    }
    
    private static boolean checkRegistrationCreds(String username , String password,JLabel e1 ,JLabel e2) {
        if (username.isEmpty() || password.isEmpty()) {
            // make the empty error label visible
            e1.setVisible(true);
            return false;
        }
        
        // check if user is already registered
        try {
            File usersFile = new File("database/users.txt");
            Scanner sc = new Scanner(usersFile);
            while (sc.hasNextLine()) {
                String dbUsername = "";
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ':') break;
                    dbUsername += line.charAt(i);
                }
                username = username.trim();
                if (username.equals(dbUsername)) {
                    // make the already registered error label visible
                    e2.setVisible(true);
                    return false;
                }
            }
        } catch(IOException e) {
            System.out.println("Something went wrong during fetchin users from database : " + e);
        }
        return true;
    }
}
