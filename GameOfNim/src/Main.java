import Controllers.Controller;
import Models.Board;
import Views.Output;

public class Main {

    public static void main(String[] args) {
        // Entry point of the application, calls setup() inside the controller class to setup the board and get the game started.
	    new Controller().setup();
    }

}
