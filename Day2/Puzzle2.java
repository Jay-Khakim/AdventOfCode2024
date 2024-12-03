package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Puzzle2 {
    public static void main(String[] args){
        String fileName = "/Users/ohhyunjoo/Desktop/dev/AdventOfCode2024/Day2/input.txt";
        int safeReports = 0;
        
        try(BufferedReader br = new BufferedReader((new FileReader(fileName)))){
            String line;
            while((line = br.readLine()) != null){
                int[] numbers = Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt) // Convert to primitive int
                .toArray(); // Collect as int[]
                if(isSafe(numbers)){
                    safeReports++;
                    continue;
                }

                 // Check if removing a single level makes it safe
                for (int i = 0; i < numbers.length; i++) {
                    int[] modified = removeLevel(numbers, i); // Remove the ith level
                    if (isSafe(modified)) {
                        safeReports++;
                        break; // Stop checking further, as it's safe
                    }
                }
            }

            System.out.println("Safe reports number is " + safeReports);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSafe(int[] numbers){
        boolean increasing = true;
        boolean decreasing = true;

        for(int i = 0; i<numbers.length-1; i++){
            int difference = numbers[i+1] - numbers[i];

            if(Math.abs(difference) < 1 || Math.abs(difference) > 3){
                return false;
            }

            if(difference > 0){
                decreasing = false;
            }else if(difference < 0){
                increasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static int[] removeLevel(int[] numbers, int index){
        int[] result = new int[numbers.length - 1];
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                result[k++] = numbers[i];
            }
        }
        return result;
    }
}
