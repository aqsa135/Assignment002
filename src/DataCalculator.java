// Aqsa Noreen
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataCalculator {
    /**
     * ReadFileAL reads a CSV file and populates an ArrayList with Obj instances.
     *
     * @param MyFile A string representing the file path of the CSV file.
     * @return An ArrayList containing Obj instances created from the CSV data.
     * @throws IOException if there is a problem reading the file.
     */

    public static ArrayList<Obj> ReadFileAL(String MyFile) {
        // method implementation
        ArrayList<Obj> tags = new ArrayList<>();
        String[] tag;

        try (Scanner scanner = new Scanner(new FileReader(MyFile))) {
            System.out.println("Reading the file");

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine().trim();
                tag = currentLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                Obj entry = new Obj(tag[14], tag[16], tag[23], tag[17], tag[8]);

                if (tag[9].equals("")) {
                    entry.setOpen(true);
                } else {
                    entry.setOpen(false);
                }
                tags.add(entry);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tags;
    }

    /**
     * ReadFileLL reads a CSV file and populates a LinkedList with Obj instances.
     *
     * @param MyFile A string representing the file path of the CSV file.
     * @return A LinkedList containing Obj instances created from the CSV data.
     * @throws IOException if there is a problem reading the file.
     */

    public static LinkedList<Obj> ReadFileLL(String MyFile) {
        LinkedList<Obj> tags = new LinkedList<>();
        String[] tag;

        try (Scanner scanner = new Scanner(new FileReader(MyFile))) {
            System.out.println("Reading the file");

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine().trim();
                tag = currentLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                Obj entry = new Obj(tag[14], tag[16], tag[23], tag[17], tag[8]);

                if (tag[9].equals("")) {
                    entry.setOpen(true);
                } else {
                    entry.setOpen(false);
                }
                tags.add(entry);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return tags;
    }

    /**
     * naicsSum calculates the business summary for a given NAICS code and prints the results.
     *
     * @param naics A string representing the NAICS code to search for.
     * @param list A list of Obj instances containing business data.
     */
    public static void naicsSum(String naics, List<Obj> list) {
        int count = 0;
        HashSet<String> zips = new HashSet<>();
        HashSet<String> hoods = new HashSet<>();
        int naic = Integer.parseInt(naics);

        for (Obj item : list) {
            String r = item.getNAICS();
            String[] mult = r.split(" ");

            for (String range : mult) {
                if (isInRange(range, naic)) {
                    zips.add(item.getZip());
                    hoods.add(item.getHood());
                    count++;
                }
            }
        }

        System.out.println(naics + " Business Summary");
        System.out.println("Total Businesses: " + count);
        System.out.println("Zip codes: " + zips.size());
        System.out.println("Neighborhood: " + hoods.size());
    }

    /**
     * Determines if a given NAICS code is within a specified range.
     *
     * @param range A string representing the range in the format "lowerBound-upperBound".
     * @param naic The NAICS code to check.
     * @return A boolean indicating whether the NAICS code is within the range.
     */

    private static boolean isInRange(String range, int naic) {
        if (range.isEmpty()) {
            return false;
        }

        String[] bounds = range.split("-");
        int lowerBound = Integer.parseInt(bounds[0]);
        int upperBound = Integer.parseInt(bounds[1]);

        return naic >= lowerBound && naic <= upperBound;
    }

    /**
     * zipSum calculates the business summary for a given zip code and prints the results.
     *
     * @param zip A string representing the zip code to search for.
     * @param list A list of Obj instances containing business data.
     */


    public static void zipT(String zip, List<Obj> list) {
        int count = 0;
        HashSet<String> types = new HashSet<>();
        HashSet<String> hoods = new HashSet<>();

        for (Obj item : list) {
            if (item.getZip().equals(zip)) {
                types.add(item.getType());
                hoods.add(item.getHood());
                count++;
            }
        }

        System.out.println(zip + " Business Summary");
        System.out.println("Total Businesses: " + count);
        System.out.println("Business Types: " + types.size());
        System.out.println("Neighborhood: " + hoods.size());
    }

    /**
     * Sum calculates the total business summary, including closed and new businesses,
     * and prints the results.
     *
     * @param list A list of Obj instances containing business data.
     */

    public static void Sum(List<Obj> list) {
        int c1 = 0;
        int c2 = 0;
        int current = Calendar.getInstance().get(Calendar.YEAR);

        for (Obj item : list) {
            if (!item.isOpen()) {
                c1++;
            }
            String date = item.getsDate();
            String yearString = date.substring(date.lastIndexOf('/') + 1);
            int theYear = Integer.parseInt(yearString);
            if (current - theYear < 2) {
                c2++;
            }
        }

        System.out.println("Total number of Business Summary");
        System.out.println("Total number of Businesses: " + list.size());
        System.out.println("Closed Businesses: " + c1);
        System.out.println("New Business last year: " + c2);
    }

}


