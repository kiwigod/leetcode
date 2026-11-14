# 70 . Climbing Stairs

## Verbose Solution
This is the "inefficient" solution. It requires more memory and runtime due to the upfront calculation and data type decisions.
I initially came up with this solution because I understood that we had to determine the total number of permutations
in a multiset. Whilst writing the comments after finishing up I realised that this problem can be solved a lot easier.

## Solution
This is my final solution. It still calculates all permutations upfront, but no longer requires factorials. My decision to
calculate upfront stems from the constraints in the problem 1 <= n <= 45. This is easily managable in memory which I
generally prefer over recalculating.

The theory applied here is that the sum of permutations of the preceeding two stair lenghts must equal the total permutations
for the current stair length. This can be proven as follows:
- A stair length of 1 can only be traversed with a single step (1).
- A stair length of 2 can be uniquely traversed in the following two ways
  - Two single steps (1, 1) 
  - One double step (2)
- I treat stair length 1 and 2 as a ground truth, there is no permutation to be performed.
- Stair length N can be determined by reusing the N-1 and N-2 permutations.
  - Climb N formed from permutation N-1 needs append 1
  - Climb N formed from permutation N-2 needs append 2
  - Any N climb must end in either 1 or 2
    - Removing 1 from the climb results in a N-1 permutation
    - Removing 2 from the climb results in a N-2 permutation
  - N climbs must be unique
    - N-1 and N-2 contains no duplicates by induction from the ground truth
    - N climb cannot originate from both N-1 and N-2
      - This would require the last step to be 1 and 2 at the same time, which is not possible
  - This covers all possible permutations for stair length N
- This proves that unique climbs of stair length N must be the sum of permutations of stair length N-1 and N-2
