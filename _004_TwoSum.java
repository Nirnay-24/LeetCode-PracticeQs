/*
--------------------------------------------
Problem: #4 - Two Sum
Problem Link  : https://leetcode.com/problems/two-sum/

Problem Statement Summary:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input Format:
- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

Output Format:
- int[] → indices of two elements whose sum is equal to target

Example:
Input:
nums = [2,7,11,15], target = 9

Output:
[0,1]
*/

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> previous = new HashMap<>(); // Stores value -> index for fast lookup

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // Current number in array
            int diff = target - num; // Complement required to reach the target

            // If complement already seen, return the pair of indices
            if (previous.containsKey(diff)) {
                return new int[] { previous.get(diff), i };
            }

            // Store current number and its index in the map
            previous.put(num, i);
        }

        return new int[] {}; // No solution found (as per constraints, this line should never be reached)
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- Iterate through the array while keeping track of elements seen so far using a HashMap.
- For each element `num`, compute its complement `target - num`.
- Check if this complement exists in the map.
  - If yes, the answer is [index of complement, current index].
  - If not, store the current number and its index in the map for future reference.

This approach ensures that for every number, the code can determine in constant time whether the number needed to form the target has already been seen.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. HashMap<Integer, Integer>:
   - Purpose: To store previously seen elements and their indices for constant time lookup of complements.
   - Initialization:
     ```java
     HashMap<Integer, Integer> previous = new HashMap<>();
     ```
   - Functions used:
     - `containsKey(key)` → Checks if a complement has already been seen.
     - `get(key)` → Retrieves the index of the complement.
     - `put(key, value)` → Stores current number and its index.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1) (handled outside the method usually)
- Logic: O(n), where n = length of nums array

TOTAL:
- O(n)

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 ops allowed
- Our code: ~10^4 operations (well within limit)

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- HashMap stores up to n elements → O(n)
- Final output array of size 2 → O(1)

--------------------------------------------
SUMMARY
--------------------------------------------

- The solution uses a HashMap to track previously seen numbers and their indices.
- For every new number, the complement is checked in the map.
- If found, return both indices.
- Time complexity is linear O(n), much better than brute-force O(n^2).
- Space complexity is also linear due to HashMap.
- Efficient and handles all valid edge cases as guaranteed by the constraints.
*/
