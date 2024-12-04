import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class day3Solution {
    public static void main(String[] args) {
        String filePath = "./day3Input.txt";
        String input = readFileAsString(filePath);

        // Debug statement to check if input is read correctly
        System.out.println("Input read from file:");
        System.out.println(input);

        // initializing values for main loop
        int tempIndex = 0;
        int loopIndex = 0;
        List<Integer> firstNum = new ArrayList<>();
        List<Integer> secondNum = new ArrayList<>();
        int firstListToNum = 0;
        int secondListToNum = 0;
        int result = 0;

        //for (int i=0; i<input.length(); i++) {
        for (int i=0; i<1000; i++) {
            firstNum.clear();
            secondNum.clear();
            tempIndex = i;
            if (input.charAt(tempIndex) != 'm')
                continue;
            tempIndex++;
            if (input.charAt(tempIndex) != 'u')
                continue;
            tempIndex++;
            if (input.charAt(tempIndex) != 'l')
                continue;
            tempIndex++;
            if (input.charAt(tempIndex) != '(')
                continue;
            loopIndex = 1;
            while (Character.isDigit(input.charAt(tempIndex))) {
                if (loopIndex == 3)
                    continue;
                firstNum.add(Character.getNumericValue(input.charAt(tempIndex)));
                tempIndex++;
            }
            if (input.charAt(loopIndex) != ',')
                continue;
            tempIndex++;
            while (Character.isDigit(input.charAt(tempIndex))) {
                if (loopIndex == 3)
                    continue;
                    secondNum.add(Character.getNumericValue(input.charAt(tempIndex)));
                tempIndex++;
            }
            if (input.charAt(loopIndex) != ')')
                continue;
            firstListToNum = convertListToNumber(firstNum);
            secondListToNum = convertListToNumber(secondNum);
            result += (firstListToNum * secondListToNum);
        }

        System.out.printf("Total Value: %d\n", result);

    }

    public static int convertListToNumber(List<Integer> digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }

    public static String readFileAsString(String filePath) {
        try {
            // Read the entire file content as a single string
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Return an empty string in case of an exception
        }
    }
}