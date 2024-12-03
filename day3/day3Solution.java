import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day3Solution {
    public static void main(String[] args) {
        String filePath = "./day3Input.txt";
        String input = null;
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process each line of the file
                fileContent.append(line);
                fileContent.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        input = fileContent.toString().trim(); // Convert StringBuilder to String and trim any extra spaces

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

        for (int i=0; i<input.length(); i++) {
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
}