package scheduler;


/**
 This class is a driver class that runs the entire project.
 It is what allows the booking, cancellation, and printing of appointments to occur.
 Without this class, the project wouldn't be able to function.
 @author Karan Patel, Azaan Siddiqi
 */
public class RunProject1 {


    /**
     Creates a kiosk object and calls the run method inside the kiosk class to start the project.
     * @param args Array to store the java command line arguments.
     */
    public static void main(String[] args) {
        new Kiosk().run();
    }
}
