/*
--------------------------------------------
Problem: #2 - Maximum Matching of Players With Trainers
Problem Link  : https://leetcode.com/problems/maximum-matching-of-players-with-trainers/

Problem Statement Summary:
You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player. 
You are also given a 0-indexed integer array trainers, where trainers[j] represents the training capacity of the jth trainer.

The ith player can match with the jth trainer if the player's ability is less than or equal to the trainer's training capacity.
Additionally, the ith player can be matched with at most one trainer, and the jth trainer can be matched with at most one player.

Return the maximum number of matchings between players and trainers that satisfy these conditions.

Input Format:
- int[] players (1 ≤ players.length ≤ 10⁵)
- int[] trainers (1 ≤ trainers.length ≤ 10⁵)
- 1 ≤ players[i], trainers[j] ≤ 10⁹

Output Format:
- Return an integer: the maximum number of valid player-trainer matchings.

Example:
Input:
players = [4,7,9]
trainers = [8,2,5,8]

Output:
2
*/

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int jIndex = 0; // Pointer for available trainers
        int match = 0;  // Counter for successful matchings

        Arrays.sort(players);   // Sort player abilities in ascending order
        Arrays.sort(trainers);  // Sort trainer capacities in ascending order

        // Iterate over each player
        for (int i = 0; i < players.length; i++) {
            // Try to find a trainer for the current player
            for (int j = jIndex; j < trainers.length; j++) {
                if (players[i] <= trainers[j]) {
                    match++;       // Found a valid trainer
                    jIndex = j+1;  // Move trainer pointer forward
                    break;         // Move to next player
                }
            }
        }

        return match; // Return total number of matchings
    }
}

/*
--------------------------------------------
DETAILED EXPLANATION OF LOGIC AND ANALYSIS
--------------------------------------------

APPROACH (Very Easy to Understand):

1. Sort the `players` array so that we can try to match players from weakest to strongest.
2. Sort the `trainers` array to match from least to greatest capacity.
3. Use two pointers:
   - One to iterate over each player.
   - Another (`jIndex`) to iterate through available trainers.
4. For each player, try to find the first trainer who can handle their ability.
5. If a match is found, increment the match counter and move both pointers forward.
6. Return the total number of matches found.

This works because sorting helps us greedily assign the least powerful available trainer to each player,
which ensures that we maximize the total number of possible matches.

--------------------------------------------
USAGE OF DATA STRUCTURES:
--------------------------------------------

1. Arrays:
   - Purpose: To hold the abilities of players and capacities of trainers.
   - Initialization:
     ```java
     int[] players = ...;
     int[] trainers = ...;
     ```
   - Functions used:
     - `Arrays.sort()` → Used to sort the arrays in ascending order for greedy matching.

--------------------------------------------
TIME COMPLEXITY AND PERFORMANCE ANALYSIS
--------------------------------------------

PER TEST CASE:
- Input reading: O(n)
- Sorting players and trainers: O(n log n + m log m)
- Matching logic (two-pointer): O(n + m)

TOTAL:
- O(n log n + m log m), where n = number of players, m = number of trainers

✅ Confirmed efficient under standard competitive programming limits.

COMPETITIVE LIMITS:
- 1 sec → 10^8 ops allowed
- Our code: ~2×10⁵ log(10⁵) ≈ ~2×10⁶ operations (very safe)

--------------------------------------------
SPACE COMPLEXITY
--------------------------------------------

- O(1) extra space (in-place sorting and pointer variables)
- O(n + m) for input arrays (already provided)

--------------------------------------------
SUMMARY
--------------------------------------------

- Sort both arrays to allow greedy matching.
- Use two pointers to scan players and trainers in order.
- Greedily assign the earliest available qualified trainer to each player.
- Efficient, clean, and works for all valid edge cases.
*/
