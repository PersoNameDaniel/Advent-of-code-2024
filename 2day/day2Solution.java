import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;

public class Day2Solution {
    public static void main(String[] args) throws IOException {
        int[][] data = new int[8][1000];
        String content = new String(Files.readAllBytes(Paths.get("day2Input.txt")));
        String[] lines = content.split("\n");
        for (int i = 0; i < 8; i++) {
            String[] numbers = lines[i].trim().split("\\s+");
            for (int j = 0; j < 1000; j++) {
                data[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        // Print the array to verify
        for (int[] row : data) {
            System.out.println(Arrays.toString(row));
        }
    }
}