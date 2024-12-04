import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class solutionDay4 {
    public static void main(String[] args) {
        String filePath = "inputDay4-1.txt";
        char[][] input = new char[140][140];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 140) {
                for (int col = 0; col < 140 && col < line.length(); col++) {
                    input[row][col] = line.charAt(col);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the array to verify
        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}