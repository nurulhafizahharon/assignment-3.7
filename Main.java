import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        // LOGGING TO A FILE
        try {
            Handler fileHandler = new FileHandler("assignmentlog.log", true);
            // Format the log messages
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            // add the handler to the logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.out.println(e);
        }

        logger.info("🟢 Application start.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer: ");

        try {
            int numberScan = scanner.nextInt();
            System.out.println("You have entered: " + numberScan);
            scanner.close();
            logger.info("🟢 User have enter an integer: " + numberScan);
        } catch (InputMismatchException e) {
            System.out.println(e);
            logger.severe("🔴 User enter invalid input. ERROR: " + e);
        }

    }
}