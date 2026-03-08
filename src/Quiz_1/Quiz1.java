package Quiz_1;
/*
  CS305 - Quiz 1 - Spring 2026
  Write a Java method that takes an int array as a parameter
  and returns a new array containing only the elements that are greater than 5.
  Example 1:
  Input: [1,9,3,8,10,4,5]
  Output: [9,8,10]
  Example 2:
  Input file: [4,9,10,5,2,8,6,9]
  Output: [9,10,8,6,9]
 */

import java.util.*;

public class Quiz1 {
    /**
     * Returns a new array containing only the elements
     * from the input array that are greater than 5.
     *
     * @param arr the input integer array
     * @return a new array containing all values greater than 5
     */
    public static int[] GreaterThanFive(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5)
                list.add(arr[i]);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GreaterThanFive(new int[]{1, 9, 3, 8, 10, 4, 5})));
        System.out.println(Arrays.toString(GreaterThanFive(new int[]{4, 9, 10, 5, 2, 8, 6, 9})));
    }
}