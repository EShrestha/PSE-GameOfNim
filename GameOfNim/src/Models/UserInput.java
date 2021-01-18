package Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String getString(String prompt){
        while(true){
            System.out.print(prompt);
            try{
                return br.readLine();
            } catch (IOException e){
                System.err.println("***Something went wrong while getting user input***");
            }
        }
    }

    public static int getInt(String prompt, int min, int max){
        int tempInt;
        while(true){
            try {
                tempInt = Integer.parseInt(getString(prompt));
                if(tempInt >= min && tempInt <= max){return tempInt;}
                else{ System.out.println("***Please enter numbers within bounds***");}
            } catch (Exception e){System.out.println("***Please enter an integer***");}
        }
    }

    public static int getInputFromMenu(String[] menuItems, boolean hasExit){
        while(true){
            for (String str : menuItems) {System.out.println(str);}
            try { return getInt("Enter Selection: ", (hasExit ? 0 : 1), (hasExit?menuItems.length-1:menuItems.length));}
            catch (Exception e){System.out.println("***Something went wrong with your selection, try again***");}
        }
    }



}
