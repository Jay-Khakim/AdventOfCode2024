package Day1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle1 {
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

        // System.out.println("Array 1: ");
        // for(int num : array1Final){
        //     System.out.print(num + " ");
        // }

        // System.out.println("Array 2: ");
        // for(int num : array2Final){
            //     System.out.print(num + " ");
            // }
        
        
        Arrays.sort(array1Final);
        Arrays.sort(array2Final);

        System.out.println("Sorted Array 1 : " + Arrays.toString(array1Final));
        System.out.println("Sorted Array 2 : " + Arrays.toString(array2Final));
    
        int sumOfDistance = 0;
    
        for(int i = 0; i<array1Final.length; i++){
            sumOfDistance += Math.abs(array2Final[i] - array1Final[i]);
        }

        System.out.println("The sum of distance: " + sumOfDistance);
        
    }

}
