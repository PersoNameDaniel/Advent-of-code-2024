import java.io.*;
import java.util.*;

public class firstPartSolutionDay5 {
    public static void main(String[] args) throws IOException {
        String filePath = "5day/inputDay5";
        List<Tuple> firstSection = new ArrayList<>();
        List<List<Integer>> secondSection = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstSection = true;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                isFirstSection = false;
                continue;
            }

            if (isFirstSection) {
                String[] parts = line.split("\\|");
                int first = Integer.parseInt(parts[0]);
                int second = Integer.parseInt(parts[1]);
                firstSection.add(new Tuple(first, second));
            } else {
                String[] parts = line.split(",");
                List<Integer> list = new ArrayList<>();
                for (String part : parts) {
                    list.add(Integer.parseInt(part));
                }
                secondSection.add(list);
            }
        }
        br.close();

        // Print the results for verification
        //System.out.println("First Section (List of Tuples): " + firstSection);
        //System.out.println("Second Section (List of Lists): " + secondSection);

        int answer = 0;

        for (List<Integer> listRow : secondSection) {
            if (checkPageOrder(listRow, firstSection) == true) {
                answer += listRow.get((listRow.size()/2) - 1);
            }
        }

        System.out.printf("Total: %d\n", answer);
    }

    public static boolean checkPageOrder(List<Integer> listInput, List<Tuple> tupleInput) {
        for (Tuple pageOrder : tupleInput) {
            for (int i=0; i<listInput.size(); i++) {
                if (listInput.get(i) == pageOrder.second) {
                    for (int j=0; j<(listInput.size()-i); j++) {
                        if (listInput.get(j) == pageOrder.first) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

class Tuple {
    int first;
    int second;

    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}