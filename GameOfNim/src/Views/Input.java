package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    TODO finish this comment about the loop
    */
    public static int requestNumber(String text){
        boolean isNumber = false;
        int num = -2 ^ 31;
        do {
        try {
                System.out.println(text);
                num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                isNumber = true;
        } catch (IOException e) {
            System.out.println("Buffered Reader encountered an IOException");
        } catch (NumberFormatException nfe){
            System.out.println("Input was not a number.");
        }
        } while (!isNumber);
        return num;
    }

    public static int[] requestMove(String text){
        System.out.println(text);
        int[] a = new int[2];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Format your move like this: x,y where x is the row and y is the number you want to take.");
            String input = br.readLine();
            Matcher m = Pattern.compile("\\d+").matcher(input);
            int i = 0;
            while(m.find()){
                if(!(a.length <= i)){
                    a[i] = Integer.parseInt(m.group());
                }
            }
        } catch (IOException ioe){
            System.out.println("IOException");
        }
        return a;
    }
}
