import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Assignment02 {
    public static void main(String[] args) {
        String MyFile = args[0];
        String type = args[1];
        Deque<String> queue = new ArrayDeque<>();

        DataCalculator dataCalculator = new DataCalculator();

        if (MyFile != null) {
            if (Objects.equals(type, "AL")) {
                List<Obj> aList = new ArrayList<>();
                aList = dataCalculator.ReadFileAL(MyFile);
                UserInput userInput = new UserInput(aList, queue);
                userInput.processUserInput();
            } else if (Objects.equals(type, "LL")) {
                List<Obj> lList = new LinkedList<>();
                lList = dataCalculator.ReadFileLL(MyFile);
                UserInput userInput = new UserInput(lList, queue);
                userInput.processUserInput();
            } else {
                System.out.println("Enter a valid list type");
            }
        } else {
            System.out.println("Enter a valid file");
        }
    }
}


