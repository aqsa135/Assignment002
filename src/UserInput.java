import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private List<Obj> list;
    private Deque<String> queue;
    private DataCalculator dataCalculator;

    public UserInput(List<Obj> list, Deque<String> queue) {
        this.list = list;
        this.queue = queue;
        this.dataCalculator = new DataCalculator();
    }

    public void processUserInput() {
        Scanner sc = new Scanner(System.in);
        String contains = "";
        String[] line = null;
        System.out.println("Enter commands, or enter EXIT to exit");
        contains = sc.nextLine();
        queue.add(contains);
        while (!contains.equals("EXIT")) {
            if (contains.contains("Zip")) {
                line = contains.split(" ");
                String zip = line[1];
                dataCalculator.zipT(zip, list);
            } else if (contains.contains("NAICS")) {
                line = contains.split(" ");
                String naics = line[1];
                dataCalculator.naicsSum(naics, list);
            } else if (contains.contains("Summary")) {
                dataCalculator.Sum(list);
            } else if (contains.contains("History")) {
                for (String element : queue) {
                    System.out.println(element);
                }
            } else {
                System.out.println("Enter a valid command!");
            }
            System.out.println("Enter commands, or enter EXIT to exit");
            contains = sc.nextLine();
            queue.add(contains);
        }
    }
}


