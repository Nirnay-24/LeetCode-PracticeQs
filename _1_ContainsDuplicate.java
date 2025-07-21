/*
------------------------------------------------
Problem: #1 - Contains Duplicate
Problem Link: https://leetcode.com/problems/contains-duplicate/description/

Problem Statement Summary:
Given an integer array `nums`, return `true` if any value appears at least twice in the array,
and return `false` if every element is distinct.

Input Format:
- A single array `nums` of integers
  - 1 <= nums.length <= 10^5
  - -10^9 <= nums[i] <= 10^9

Output Format:
- Return `true` if there are any duplicates
- Return `false` if all elements are unique

Examples:
Input: nums = [1, 2, 3, 1]
Output: true

Input: nums = [1, 2, 3, 4]
Output: false

Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true

Approach:
- Use a HashSet to track numbers seen while iterating through the array.
- For each number:
    - If it's already in the HashSet, return true (duplicate found).
    - Otherwise, add it to the HashSet.
- If iteration completes without finding any duplicates, return false.

Why This Works:
- A HashSet allows O(1) average time complexity for insertions and lookups.
- Efficiently tracks whether a number has been seen before.

Edge Cases:
- Empty array or array with one element → false (no duplicate possible)
- Large arrays are handled efficiently due to constant-time operations with HashSet

Time and Space Complexity:
- Time Complexity: O(n), where n = length of the array
- Space Complexity: O(n), for storing elements in the HashSet

Summary:
- Checks for duplicates using a HashSet.
- More optimal than brute-force O(n²) nested loops.
- Passes all constraints efficiently.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Set to keep track of unique elements
        HashSet<Integer> seen = new HashSet<>();

        // Iterate over each element in the array
        for (int each : nums) {
            // If the element is already in the set, it's a duplicate
            if (seen.contains(each)) {
                return true;
            }
            // Otherwise, add it to the set
            seen.add(each);
        }

        // No duplicates found after full scan
        return false;
    }
}

/*
TLE Brute Force Version:

This version compares every possible pair of elements to find a duplicate.
It has O(n^2) time complexity and will Time Limit Exceed for large inputs.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j){
                    continue;
                }
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
*/
