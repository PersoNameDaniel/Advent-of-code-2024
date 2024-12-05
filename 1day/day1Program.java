import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class day1Program {

    // declaration of static variables
    private static final String FILE_PATH = "1day/day1Input.txt";

    public static List<ArrayList<Integer>> getPuzzleInput(String filePath) throws IOException {
        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.trim().split("\\s+");
            if (values.length == 2) {
                column1.add(Integer.parseInt(values[0]));
                column2.add(Integer.parseInt(values[1]));
            }
        }
        br.close();

        List<ArrayList<Integer>> columns = new ArrayList<>();
        columns.add(column1);
        columns.add(column2);
        return columns;
    }
    public static int findDelta(List<ArrayList<Integer>> input) {
        int delta = 0;
        ArrayList<Integer> column1 = input.get(0);
        ArrayList<Integer> column2 = input.get(1);
        int size = column1.size();
        for (int i = 0; i < size; i++) {
            delta += Math.abs(column2.get(i) - (column1.get(i)));
        }
        return delta;
    }

    public static int findSimilarityScore(List<ArrayList<Integer>> input) {
        int similarityScore = 0;
        ArrayList<Integer> column1 = input.get(0);
        ArrayList<Integer> column2 = input.get(1);
        for (int i = 0; i < column1.size(); i++)
            similarityScore += (column1.get(i) * findColumn2Quantity(column1.get(i), column2));
        return similarityScore;
    }

    public static int findColumn2Quantity(int value, ArrayList<Integer> column2) {
        int quantity = 0;
        for (int i = 0; i < column2.size(); i++) {
            if (column2.get(i) == value) {
                quantity++;
            }
        }
        return quantity;
    }

    public static void main(String[] args) throws IOException {
        List<ArrayList<Integer>> columns = getPuzzleInput(FILE_PATH);
        ArrayList<Integer> column1 = columns.get(0);
        ArrayList<Integer> column2 = columns.get(1);

        Collections.sort(column1);
        Collections.sort(column2);

        int totalDelta = findDelta(columns);
        int totalSimilarityScore = findSimilarityScore(columns);

        System.out.printf("Total Delta: %d \n", totalDelta);
        System.out.printf("Total Similarity Score: %d \n", totalSimilarityScore);



    }
}