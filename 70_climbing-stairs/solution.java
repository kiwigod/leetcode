/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 */
class Solution {
    // Create a lookup for all possible permutations within the constraints
    // See explanation in the README
    private int[] permutations = new int[46];
    {
        permutations[1] = 1;
        permutations[2] = 2;
        for (int i = 3; i < permutations.length; i++)
        {
            permutations[i] = permutations[i-1] + permutations[i-2];
        }
    }

    public int climbStairs(int n) {
        if (n < 3) return n;

        return permutations[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(Integer.parseInt(args[0])));
    }
}
