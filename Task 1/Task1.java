/**
 * CS305 - Task 1 - Spring 2026
 * Write a Java method that reads words from a file using Scanner
 * and checks whether each word contains only distinct (non-repeating) characters.
 * Return true if all words are valid,
 * otherwise return false if any word contains duplicate letters.
 * Example 1:
 * Input file: omar 
 *             ahmed
 *             mahmoud
 * Output: false (because "mahmoud" contains repeated letter 'm')
 * Example 2:
 * Input file: omar 
 *             ahmed
 *             omar
 * Output: true (because each word individually contains only distinct (non-repeating) letters)
*/

import java.io.*;
import java.util.*;

public class Task1 {
    /**
     * Reads all words from a file and checks whether every word
     * contains only distinct (non-repeating) characters.
     *
     * @param fileName the path of the file to read from
     * @return true if all words in the file contain distinct letters,
     *         false if at least one word contains repeated letters
     */
    public static boolean allWordsDistinctLetters(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                if (!isDistinct(word)) return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * Checks whether a given word contains only distinct characters.
     *
     * @param word the input string to be checked
     * @return true if all characters in the word are unique,
     *         false if there is at least one repeated character
     */
    public static boolean isDistinct(String word) {
        Set<Character> set = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allWordsDistinctLetters("input.txt"));
    }
}
