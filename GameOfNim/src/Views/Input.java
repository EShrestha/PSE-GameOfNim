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
            System.out.print(">> ");
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.out.println("Buffered Reader encountered an IOException");
        }
        return "";
    }

    /*requestNumber takes in a String and relays it to the user, usually as a prompt for input.
    The console is then read to get user input and then parses it to an int, which is passed back.
    Until the input properly parses as number, the loop will continue asking for input
    */
    public static int requestNumber(String text){
        boolean isNumber = false;
        int num = -2 ^ 31;
        do {
        try {
                System.out.print(text + "\n>> ");
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

    /* takes in a string which is printed, and returns an int array
    of size 2, the first of which is the row and the second is how
    many objects will be taken from that row
     */
    public static int[] requestMove(String text){
        System.out.println(text);
        int[] a = new int[2];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Format your move like this: x,y where x is the row and y is the number you want to take.");
            System.out.print(">> ");
            String input = br.readLine();
            Matcher m = Pattern.compile("\\d+").matcher(input);
            int i = 0;
            while(m.find()){
                if(!(a.length <= i)){
                    a[i++] = Integer.parseInt(m.group()); // Fixed: i was not being incremented after operation so it would only put digits in index 0
                }
            }
        } catch (IOException ioe){
            System.out.println("IOException");
        }
        return a;
    }
}
