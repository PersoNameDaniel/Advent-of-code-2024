import java.io.*;
import java.util.*;

public class Day2Solution {
    public static void main(String[] args) {
        String fileName = "day2Input.txt";
        int[][] dataArray = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<int[]> dataList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] stringNumbers = line.split(" ");
                int[] numbers = new int[stringNumbers.length];
                for (int i = 0; i < stringNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(stringNumbers[i]);
                }
                dataList.add(numbers);
            }

            // Convert List<int[]> to int[][]
            dataArray = new int[dataList.size()][];
            for (int i = 0; i < dataList.size(); i++) {
                dataArray[i] = dataList.get(i);
            }
        }

        // Print the 2D array to verify
        if (dataArray != null) {
            for (int[] row : dataArray) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}