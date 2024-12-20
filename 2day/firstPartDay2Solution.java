import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class firstPartDay2Solution {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> data = readFile("2day/day2Input");

        // Sample input
        List<List<Integer>> sample = new ArrayList<>();
        sample.add(List.of(7, 6, 4, 2, 1));
        sample.add(List.of(1, 2, 7, 8, 9));
        sample.add(List.of(9, 7, 6, 2, 1));
        sample.add(List.of(1, 3, 2, 4, 5));
        sample.add(List.of(8, 6, 4, 4, 1));
        sample.add(List.of(1, 3, 6, 7, 9));

        int safeReports = 0;
        int safeSampleReports = 0;

        for (List<Integer> report : sample) {
            if (checkIfReportIsSafe(report)) {
                safeSampleReports++;
            }
        }
        
        for (List<Integer> report : data) {
            if (checkIfReportIsSafe(report)) {
                safeReports++;
            }
        }

        System.out.printf("Sample safe reports: %d\n", safeSampleReports);
        System.out.printf("Safe reports: %d\n", safeReports);
    }

    public static List<List<Integer>> readFile(String fileName) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines.stream()
                    .map(line -> line.split("\\s+"))
                    .map(arr -> {
                        List<Integer> list = new ArrayList<>();
                        for (String num : arr) {
                            list.add(Integer.parseInt(num));
                        }
                        return list;
                    })
                    .collect(Collectors.toList());
    }
    public static boolean checkIfReportIsSafe(List<Integer> report) {
        boolean isIncreasing = report.get(1) > report.get(0);
        for (int i=0; i<report.size()-1; i++) {
            int diff = Math.abs(report.get(i+1) - report.get(i));
            if ((diff > 3) || (diff < 1))
                return false;

            if (isIncreasing && (report.get(i+1) < report.get(i)))
                return false;

            if (!isIncreasing && (report.get(i+1) > report.get(i)))
                return false;
        }
        return true;
    }
}