package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle2 {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/ohhyunjoo/Desktop/dev/AdventOfCode2024/Day3/input.txt";
        int result = 0;

       BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
         // Regex patterns
         String doRegex = "do\\(\\)";
         String dontRegex = "don't\\(\\)";
         String mulRegex = "mul\\((\\d+),(\\d+)\\)";
         
         Pattern doPattern = Pattern.compile(doRegex);
         Pattern dontPattern = Pattern.compile(dontRegex);
         Pattern mulPattern = Pattern.compile(mulRegex);
         
         boolean enabled = true; // Initially, mul instructions are enabled
 
         while ((line = br.readLine()) != null) {
             Matcher doMatcher = doPattern.matcher(line);
             Matcher dontMatcher = dontPattern.matcher(line);
             Matcher mulMatcher = mulPattern.matcher(line);
 
             // Process all instructions in the order they appear
             int index = 0; // To track the position while processing the line
             while (index < line.length()) {
                 boolean matched = false;
 
                 if (doMatcher.find(index) && doMatcher.start() == index) {
                     enabled = true; // Enable mul instructions
                     index = doMatcher.end();
                     matched = true;
                 }
 
                 if (dontMatcher.find(index) && dontMatcher.start() == index) {
                     enabled = false; // Disable mul instructions
                     index = dontMatcher.end();
                     matched = true;
                 }
 
                 if (mulMatcher.find(index) && mulMatcher.start() == index) {
                     if (enabled) {
                         // Extract and multiply the numbers
                         int num1 = Integer.parseInt(mulMatcher.group(1));
                         int num2 = Integer.parseInt(mulMatcher.group(2));
                         result += num1 * num2;
                     }
                     index = mulMatcher.end();
                     matched = true;
                 }
 
                 // If no pattern matched, move to the next character
                 if (!matched) {
                     index++;
                 }
             }
         }
 
         System.out.println("Result: " + result);
    }
}
