/*
* Class which catch from keyboard button 'q' and stop producers
*/
import java.util.Scanner;

public class EndProgram implements Runnable {
    private static boolean isRunning = true;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (isRunning) {
            String button = scan.next();
            if (button.equals("q")) {
                isRunning = false;
            }
        }
    }

    boolean getIsRunning(){
        return isRunning;
    }
}
