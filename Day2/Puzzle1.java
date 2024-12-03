package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Puzzle1 {
    public static void main(String[] args){
        String fileName = "/Users/ohhyunjoo/Desktop/dev/AdventOfCode2024/Day2/input.txt";
        int safeReports = 0;
        
        try(BufferedReader br = new BufferedReader((new FileReader(fileName)))){
            String line;
            while((line = br.readLine()) != null){
                Integer[] numbers = Arrays.stream(line.split("\\s+"))
                                    .map(Integer::parseInt) // Convert each String to Integer
                                    .toArray(Integer[]::new); // Collect as Integer[]
                // System.out.println(Arrays.toString(numbers));

                //My First Solution

                // if(numbers[1] > numbers[0] && numbers[1] - numbers[0] < 3){
                //     for(int i = 2; i<numbers.length; i++){
                //         if(numbers[i] > numbers[i-1] && numbers[i] - numbers[i-1] < 3){
                //             if(i == numbers.length-1){
                //                 safeReports += 1;
                //                 System.out.println("Increasing array: "+ Arrays.toString(numbers));
                //             }
                //         }else{
                //             break;
                //         }
                //     }

                // }else if(numbers[1] < numbers[0] && numbers[0] - numbers[1] < 3){
                //     for(int i = 2; i<numbers.length; i++){
                //         if(numbers[i] < numbers[i-1] && numbers[i-1] - numbers[i] < 3){
                //             if(i == numbers.length-1){
                //                 safeReports += 1;
                //                 System.out.println("Decreasing array: "+ Arrays.toString(numbers));
                //             }
                //         }else{
                //             break;
                //         }
                //     }
                // }else{
                //     continue;
                // }

                //Second Solution using function 
                if(isSafe(numbers)){
                    safeReports++;
                }
            }

            System.out.println("Safe reports number is " + safeReports);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSafe(Integer[] numbers){
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
}
