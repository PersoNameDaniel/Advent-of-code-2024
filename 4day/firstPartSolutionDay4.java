import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class firstPartSolutionDay4 {
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

        int XMASCount = 0;

        for (int i = 0; i < 140; i++) {
            for (int j = 0; j < 140; j++) {
                if (input[i][j] != 'X')
                    continue;
                XMASCount += checkNorth(input, i, j);
                XMASCount += checkSouth(input, i, j);
                XMASCount += checkEast(input, i, j);
                XMASCount += checkWest(input, i, j);
                XMASCount += checkNorthEast(input, i, j);
                XMASCount += checkNorthWest(input, i, j);
                XMASCount += checkSouthEast(input, i, j);
                XMASCount += checkSouthWest(input, i, j);
            }
        }

        System.out.printf("Quantity of \"XMAS\" found: %d\n", XMASCount);
    }

    public static int checkNorth(char[][] input, int row, int col) {
        if (row < 3)
            return 0;
        if (input[row-1][col] != 'M')
            return 0;
        if (input[row-2][col] != 'A')
            return 0;
        if (input[row-3][col] != 'S')
            return 0;
        return 1;
    }
    public static int checkSouth(char[][] input, int row, int col) {
        if (row > 136)
            return 0;
        if (input[row+1][col] != 'M')
            return 0;
        if (input[row+2][col] != 'A')
            return 0;
        if (input[row+3][col] != 'S')
            return 0;
        return 1;
    }
    public static int checkEast(char[][] input, int row, int col) {
        if (col > 136)
            return 0;
        if (input[row][col+1] != 'M')
            return 0;
        if (input[row][col+2] != 'A')
            return 0;
        if (input[row][col+3] != 'S')
            return 0;
        return 1;
    }
    public static int checkWest(char[][] input, int row, int col) {
        if (col < 3)
            return 0;
        if (input[row][col-1] != 'M')
            return 0;
        if (input[row][col-2] != 'A')
            return 0;
        if (input[row][col-3] != 'S')
            return 0;
        return 1;
    }
    public static int checkNorthEast(char[][] input, int row, int col) {
        if (row < 3 || col > 136)
            return 0;
        if (input[row-1][col+1] != 'M')
            return 0;
        if (input[row-2][col+2] != 'A')
            return 0;
        if (input[row-3][col+3] != 'S')
            return 0;
        return 1;
    }
    public static int checkNorthWest(char[][] input, int row, int col) {
        if (row < 3 || col < 3)
            return 0;
        if (input[row-1][col-1] != 'M')
            return 0;
        if (input[row-2][col-2] != 'A')
            return 0;
        if (input[row-3][col-3] != 'S')
            return 0;
        return 1;
    }
    public static int checkSouthEast(char[][] input, int row, int col) {
        if (row > 136 || col > 136)
            return 0;
        if (input[row+1][col+1] != 'M')
            return 0;
        if (input[row+2][col+2] != 'A')
            return 0;
        if (input[row+3][col+3] != 'S')
            return 0;
        return 1;
    }
    public static int checkSouthWest(char[][] input, int row, int col) {
        if (row > 136 || col < 3)
            return 0;
        if (input[row+1][col-1] != 'M')
            return 0;
        if (input[row+2][col-2] != 'A')
            return 0;
        if (input[row+3][col-3] != 'S')
            return 0;
        return 1;
    }
}