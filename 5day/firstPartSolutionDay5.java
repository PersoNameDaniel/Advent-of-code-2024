import java.io.*;
import java.util.*;

public class firstPartSolutionDay5 {
    public static void main(String[] args) throws IOException {

        // Sample input
        List<Tuple> sampleFirstSection = Arrays.asList(
            new Tuple(47, 53),
            new Tuple(97, 13),
            new Tuple(97, 61),
            new Tuple(97, 47),
            new Tuple(75, 29),
            new Tuple(61, 13),
            new Tuple(75, 53),
            new Tuple(29, 13),
            new Tuple(97, 29),
            new Tuple(53, 29),
            new Tuple(61, 53),
            new Tuple(97, 53),
            new Tuple(61, 29),
            new Tuple(47, 13),
            new Tuple(75, 47),
            new Tuple(97, 75),
            new Tuple(47, 61),
            new Tuple(75, 61),
            new Tuple(47, 29),
            new Tuple(75, 13),
            new Tuple(53, 13)
        );

        List<List<Integer>> sampleSecondSection = Arrays.asList(
            Arrays.asList(75, 47, 61, 53, 29),
            Arrays.asList(97, 61, 53, 29, 13),
            Arrays.asList(75, 29, 13),
            Arrays.asList(75, 97, 47, 61, 53),
            Arrays.asList(61, 13, 29),
            Arrays.asList(97, 13, 75, 29, 47)
        );

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

        int sampleAnswer = 0;
        int answer = 0;

        sampleAnswer += checkPageOrder(sampleFirstSection, sampleSecondSection);
        answer += checkPageOrder(firstSection, secondSection);

        System.out.printf("Sample total: %d, Expected: 143\n", sampleAnswer);
        System.out.printf("Total: %d\n", answer);
    }

    public static int checkPageOrder(List<Tuple> allPageOrder, List<List<Integer>> pages) {
        int centerPages = 0;

        for (List<Integer> pageRow : pages) {
            boolean inOrder = true;

            for (int i = 0; i < pageRow.size(); i++) {
                int page = pageRow.get(i);

                for (Tuple individualPageOrder : allPageOrder) {
                    if (individualPageOrder.second == page) {
                        // check for first page in remaining pages
                        for (int j = i + 1; j < pageRow.size(); j++) {
                            if (individualPageOrder.first == pageRow.get(j)) {
                                inOrder = false;
                                break;
                            }
                        }
                        if (!inOrder)
                            break;
                    }
                }
                if (!inOrder)
                        break;
            }
            if (inOrder)
                centerPages += pageRow.get(pageRow.size() / 2);
        }
        return centerPages;
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