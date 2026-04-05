# Algorithms in Java (CS305) - Spring 2026

This repository contains course tasks and quizzes for Algorithms in Java (CS305).

🗂️ Repository Structure
```
cs305-algo/
├── src/
│   └── Quiz_1/
│       └── Quiz1.java
│   └── Quiz_2/
│       └── Q1.png
│       └── Q2.png
│   └── Quiz_3/
│       └── Quiz_Q1.png
│       └── Quiz_Q2.java
│   └── Task_1/
│       └── Task1.java
│   └── Task_2/
│       └── Task2.java
│   └── Task_3/
│       └── Task3.java
│   └── ...
...
```

---

# Task 1 (15 Feb)

 * Write a Java method that reads words from a file using Scanner and checks whether each word contains only distinct (non-repeating) characters.
 Return true if all words are valid, otherwise return false if any word contains duplicate letters.
 ## Example 1:
 * Input file: omar 
               ahmed
               mahmoud
 * Output: false (because "mahmoud" contains repeated letter 'm')
 ## Example 2:
 * Input file: omar 
               ahmed
               omar
 * Output: true (because each word individually contains only distinct (non-repeating) letters)

---

# Quiz 1 (22 Feb)

 * Write a Java method that takes an int array as a parameter and returns a new array containing only the elements that are greater than 5.
 ## Example 1:
 * Input: [1,9,3,8,10,4,5]
 * Output: [9,8,10]
 ## Example 2:
 * Input file: [4,9,10,5,2,8,6,9]
 * Output: [9,10,8,6,9]

---

# Task 2 (1 Mar)

 * Write a Java method that takes an int array as a parameter and returns the sum of its elements using recursion with two pointers.
 ## Example 1:
 * Input: [1,9,3,8,10,4]
 * Output: 35
 ## Example 2:
 * Input file: [1,2,3,4,5]
 * Output: 15

---

# Quiz 2 (8 Mar) 
1) Quiz 2 - First Question<br><br>
![Quiz 2 - First Question](src/Quiz_2/Q1.png)<br><br>
2) Quiz 2 - Second Question<br><br>
![Quiz 2 - Second Question](src/Quiz_2/Q2.png)

---

# Task 3 (15 Mar)

 * Write a Java method that takes a sorted int array (may contain duplicates) and a target value, and returns the first and last position of the target in int array using binary search and (divide & conquer) technique.
 ## Example 1:
 * Input: [1, 2, 3], target = 3
 * Output: [2, 2]
 * Explanation: Target 3 appears only at index 2
 ## Example 2:
 * Input: [1, 2, 3, 3, 4], target = 3
 * Output: [2, 3]
 * Explanation: Target 3 appears at indices 2 and 3
 ## Example 3:
 * Input: [1, 2, 3, 4, 5], target = 6
 * Output: [-1, -1]
 * Explanation: Target 6 not found in array
---

# Quiz 3 (5 Apr)

1) Quiz 3 - First Question<br><br>
![Quiz 3 - First Question](src/Quiz_3/Quiz3_Q1.png)<br><br>

2) Quiz 2 - Second Question<br>
* Using the Divide and Conquer approach, write a method that checks if an array is sorted in ascending order or not.
## Example 1:
* Input: [1, 2, 3, 4]
* Output: true
## Example 2:
* Input: [1, 2, 3, 3, 4]
* Output: true
## Example 3:
* Input: [1, 2, 5, 3]
* Output: false
* Explanation: not sorted due to 5 > 3 NOT 5 <= 3
---