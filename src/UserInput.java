import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private List<Obj> list;
    private Deque<String> queue;
    private DataCalculator dataCalculator;

    // Constructor for UserInput class

    public UserInput(List<Obj> list, Deque<String> queue) {
        this.list = list;
        this.queue = queue;
        this.dataCalculator = new DataCalculator();
    }

    // Method to process user input

    public void processUserInput() {
        // Initialize scanner for user input

        Scanner sc = new Scanner(System.in);
        String contains = "";
        String[] line = null;
        // Prompt user for input

        System.out.println("Enter commands, or enter EXIT to exit");
        contains = sc.nextLine();
        queue.add(contains);
        // Keep processing user input until they enter "EXIT"

        while (!contains.equals("EXIT")) {
            if (contains.contains("Zip")) {
                // Split the input to get zip code

                line = contains.split(" ");
                String zip = line[1];
                // Call zipT method with the zip code and list

                dataCalculator.zipT(zip, list);
            } else if (contains.contains("NAICS")) {
                // Split the input to get NAICS code

                line = contains.split(" ");
                String naics = line[1];
                dataCalculator.naicsSum(naics, list);
            } else if (contains.contains("Summary")) {
                // Call naicsSum method with the NAICS code and list

                dataCalculator.Sum(list);
            } else if (contains.contains("History")) {
                for (String element : queue) {
                    System.out.println(element);
                }
            } else { // If the command is invalid, notify the user

                System.out.println("Enter a valid command!");
            }
            System.out.println("Enter commands, or enter EXIT to exit");
            contains = sc.nextLine();
            queue.add(contains);
        }
    }
}


