package Quiz_3;
/*
 * CS305 - Task 3 - Spring 2026
 * using the Divide and Conquer approach,
 * write a method that checks if an array is sorted  in ascending order or not.
 * Example 1:
 * Input: arr = [1, 2, 3, 4]
 * Output: true
 *
 * Example 2:
 * Input: arr = [1, 2, 3, 3, 4]
 * Output: true
 *
 * Example 3:
 * Input: arr = [1, 2, 5, 3]
 * Output: false
 */

public class Quiz3_Q2 {
    /**
     * Checks if the subarray [low … high] is sorted in ascending order using Divide and Conquer
     *
     * @param arr  the array to check
     * @param low  the starting index of the subarray
     * @param high the ending index of the subarray
     * @return true if the subarray is sorted in ascending order, false otherwise
     */
    public static boolean isSorted(int[] arr, int low, int high) {
        // Base case: if the array is null or has 0 or 1 element, it is sorted
        if (arr == null || low >= high) return true;

        // Find the middle index to divide the array
        int mid = low + (high - low) / 2;

        // Combine step: check the boundary between left and right halves
        // If the middle element is not smaller than or equal to the next element
        // (like 3,4,2 --> 4 > 2 NOT 4 <= 2), then array is not sorted
        if (!(arr[mid] <= arr[mid + 1])) return false;

        // Recursively check if the left half and the right half are sorted
        return isSorted(arr, low, mid) && isSorted(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4}, 0, 3));
        System.out.println(isSorted(new int[]{1, 2, 3, 3, 4}, 0, 4));
        System.out.println(isSorted(new int[]{1, 2, 5, 3}, 0, 3));
        // More Test Cases
        System.out.println(isSorted(new int[]{}, 0, -1));
        System.out.println(isSorted(new int[]{3}, 0, 0));
        System.out.println(isSorted(null, 0, -1));
        System.out.println(isSorted(new int[]{3,2}, 0, 1));
        System.out.println(isSorted(new int[]{3,4}, 0, 1));
    }
}
