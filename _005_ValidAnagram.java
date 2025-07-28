/*
--------------------------------------------
Problem: #5 - Valid Anagram
Problem Link  : https://leetcode.com/problems/valid-anagram/description/

Problem Statement Summary:
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Input Format:
- 1 <= s.length <= 5 * 10^4
- 1 <= t.length <= 5 * 10^4
- s and t consist of lowercase English letters

Output Format:
- Return true if t is an anagram of s, false otherwise

Example:
Input:
s = "anagram", t = "nagaram"

Output:
true
*/

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // If the lengths are not the same, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // Sort both character arrays
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        // Compare sorted arrays
        return Arrays.equals(sChar, tChar);
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- If two strings are anagrams, they must contain the same characters with the same frequency.
- First, check if the lengths of the two strings are equal. If not, they cannot be anagrams.
- Then, convert both strings into character arrays.
- Sort both character arrays.
- Compare the sorted arrays. If they are equal, the strings are anagrams. Otherwise, they are not.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. char[] (Character Array):
   - Purpose: To store characters of the strings for sorting and comparison.
   - Initialization:
     ```java
     char[] sChar = s.toCharArray();
     char[] tChar = t.toCharArray();
     ```
   - Functions used:
     - `Arrays.sort(char[])` → Sorts the characters of the array
     - `Arrays.equals(char[], char[])` → Compares two arrays for equality

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Sorting both strings: O(n log n)
- Comparison: O(n)

TOTAL:
- Time Complexity: O(n log n)

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → ~10^8 operations allowed
- Our code: ~n log n operations where n ≤ 5 * 10^4 → Efficient

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- char[] arrays: O(n) for sChar and O(n) for tChar → total O(n)

--------------------------------------------
SUMMARY
--------------------------------------------

- Check if string lengths are equal.
- Convert both strings to character arrays.
- Sort and compare both arrays.
- Used arrays and Java utility methods for sorting and comparison.
- Handles all lowercase character cases efficiently.
- Ensures correctness even at edge input sizes.
*/
