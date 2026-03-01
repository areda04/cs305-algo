/**
 * CS305 - Task 2 - Spring 2026
 * Write a Java method that takes an int array as a parameter
 * and returns the sum of its elements using recursion with two pointers
 * Example 1:
 * Input: [1,9,3,8,10,4]
 * Output: 35
 * Example 2:
 * Input file: [1,2,3,4,5]
 * Output: 15
 */

public class Task2 {
    /**
     * Returns the sum of array elements using recursion with two pointers.
     *
     * @param arr   the input array
     * @param left  starting index
     * @param right ending index
     * @return sum of elements between left and right
     */
    public static int addArrayElements(int[] arr, int left, int right) {
        if (arr == null) return 0;
        if (left > right) return 0;
        if (left == right) return arr[left];
        return arr[left] + arr[right] + addArrayElements(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        System.out.println(addArrayElements(new int[]{1,2,3,4,5}, 0, 4));
        System.out.println(addArrayElements(new int[]{1,9,3,8,10,4,5}, 0, 5));
        System.out.println(addArrayElements(null, 0, -1));
        System.out.println(addArrayElements(new int[]{}, 0, -1));
    }
}
