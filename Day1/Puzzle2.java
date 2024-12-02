package Day1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Puzzle2 {
    public static void main(String[] args){
        String fileName = "/Users/ohhyunjoo/Desktop/dev/AdventOfCode2024/Day1/input.txt";
        ArrayList<Integer>  array1 = new ArrayList<>();
        ArrayList<Integer>  array2 = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null){
                String[] numbers = line.split("\\s+");
                if(numbers.length == 2){
                    array1.add(Integer.parseInt(numbers[0]));
                    array2.add(Integer.parseInt(numbers[1]));
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        int[] array1Final = array1.stream().mapToInt(i -> i).toArray();
        int[] array2Final = array2.stream().mapToInt(i -> i).toArray();
        
        // Frequency counting of second array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : array2Final){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        // Print frequencies
        // for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        //     System.out.println("Number " + entry.getKey() + " occurs " + entry.getValue() + " times.");
        // }
        
    
        int similarityScore = 0;
    
        for(int i = 0; i<array1Final.length; i++){
            similarityScore += array1Final[i] * frequencyMap.getOrDefault(array1Final[i], 0);
        }

        System.out.println("The similarity Score is  " + similarityScore);
        
    }

}
