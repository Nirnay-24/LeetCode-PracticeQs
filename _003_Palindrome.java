/*
--------------------------------------------
Problem: #3 - Palindrome Number  
Problem Link  : https://leetcode.com/problems/palindrome-number/description/

Problem Statement Summary:
Given an integer x, return true if x is a palindrome, and false otherwise.

Input Format:
- -2^31 <= x <= 2^31 - 1

Output Format:
- Boolean true if x is a palindrome, otherwise false

Example:
Input:
x = 121

Output:
true
*/

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes due to the minus sign
        if(x < 0){
            return false;
        }

        // Store the original value of x
        int og = x;

        // Variable to store the reversed number
        int rev = 0;

        // Reverse the number digit by digit
        while(x > 0){
            rev = (rev * 10) + (x % 10); // Add last digit of x to rev
            x /= 10;                     // Remove last digit from x
        }

        // If reversed number equals original, it's a palindrome
        return rev == og;
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

- First, handle the edge case: negative numbers are not palindromes.
- Store the original value in a variable (`og`) for comparison.
- Initialize a variable `rev` to build the reversed number.
- Use a loop to reverse the number:
  - Extract the last digit using `x % 10`.
  - Add the digit to `rev` after shifting its current digits left (`rev * 10`).
  - Remove the last digit from x using `x /= 10`.
- After the loop, compare `rev` with `og`.
- If they are equal, the number is a palindrome.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Primitive Data Types (int):
   - Purpose: To store the original number (`og`), the reversed number (`rev`), and perform arithmetic.
   - Initialization:
     ```java
     int og = x;
     int rev = 0;
     ```
   - Functions used:
     - `%` → Extract the last digit of x
     - `/` → Remove the last digit of x
     - `*` and `+` → To build the reversed number

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(1)
- Logic: O(log₁₀(n)), where n is the input number (at most 10 iterations for a 32-bit integer)

TOTAL:
- O(log₁₀(n))

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 operations allowed
- Our code: At most 10 digit-processing operations

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) → Uses a constant amount of space (only integer variables)

--------------------------------------------
SUMMARY
--------------------------------------------

- Reverses the digits of the number using arithmetic.
- Compares reversed result with original value to check palindrome status.
- Efficient solution with no use of extra memory or strings.
- Handles edge cases like negative inputs correctly.
- Uses only simple integer arithmetic for maximum performance.
*/
