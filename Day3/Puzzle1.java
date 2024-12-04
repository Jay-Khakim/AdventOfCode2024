package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle1 {
    public static void main(String[] args) {
        String fileName = "/Users/ohhyunjoo/Desktop/dev/AdventOfCode2024/Day3/input.txt";
        int result = 0;

        try (BufferedReader br = new BufferedReader((new FileReader(fileName)))) {
            String line;
            String regex = "mul\\((\\d+),(\\d+)\\)";
            Pattern pattern = Pattern.compile(regex);

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()){
                    String num1 = matcher.group(1);
                    String num2 = matcher.group(2);
                    
                    // Parse them to integers
                    int number1 = Integer.parseInt(num1);
                    int number2 = Integer.parseInt(num2);
                    
                    // Multiply the numbers
                    result += number1 * number2;
                }
            }
            System.out.println("Result: "+result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
