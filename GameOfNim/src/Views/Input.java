package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    /*requestString takes in a String and relays it to the user, usually as a prompt for input.
     The console is then read to get the user input which is passed back without alteration.
     If an exception is thrown, an empty string is returned.*/
    public static String requestString(String text){
        System.out.println(text);
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.out.println("Buffered Reader encountered an IOException");
        }
        return "";
    }

    /*requestNumber takes in a String and relays it to the user, usually as a prompt for input.
    The console is then read to get user input and then parses it to an int, which is passed back.
    if an exception is thrown (most likely due to the string being incapable of being parsed into an int)
    the minimum possible value is passed back instead (since it's unlikely to be used and something needs to be passed back*/
    public static int requestNumber(String text){
        System.out.println(text);
        try {
            return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
            System.out.println("Buffered Reader encountered an IOException");
        } catch (NumberFormatException nfe){
            System.out.println("Invalid Number");
        }
        return -(2^31);
    }

    public static String requestMove(String text){
        System.out.println(text);
        try {
            
        }
    }
}
