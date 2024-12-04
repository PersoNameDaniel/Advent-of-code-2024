import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class secondPartSolutionDay4 {
    public static void main(String[] args) {
        String filePath = "//10.18.220.100/Spencer/Documents/GitHub/Advent-Of-Code-2024/4day/inputDay4";
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

        int XmasCount = 0;

        for (int i = 1; i < 139; i++) {
            for (int j = 1; j < 139; j++) {
                if (input[i][j] != 'A')
                    continue;
                if (checkMS(input, i, j))
                    XmasCount++;
            }
        }

        System.out.printf("Quantity of \"X-MAS\" found: %d\n", XmasCount);
    }
    public static boolean checkMS(char[][] input, int row, int col) {
        if (((input[row-1][col-1] == 'M') && (input[row+1][col+1] == 'S')) || ((input[row-1][col-1] == 'S') && (input[row+1][col+1] == 'M')))
            if (((input[row-1][col+1] == 'M') && (input[row+1][col-1] == 'S')) || ((input[row-1][col+1] == 'S') && (input[row+1][col-1] == 'M')))
                return true;
        return false;
    }
}