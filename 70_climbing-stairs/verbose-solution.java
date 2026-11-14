import java.math.BigInteger;

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
    // The factorial we need further down the line is constraint bound
    // meaning we can pre-calculate it to reduce runtime
    private BigInteger[] factorials = new BigInteger[46];
    {
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;
        factorials[2] = BigInteger.TWO;
        for (int i = 3; i < factorials.length; i++)
        {
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        }
    }

    public int climbStairs(int n) {
        // We know that the longest route is always 1+1...+1
        // Therefore routes can start at 1
        BigInteger routes = BigInteger.ONE;

        boolean evenNSteps = n % 2 == 0;
        // Determine the least amount of steps required to reach the top
        int leastSteps = (n + (evenNSteps ? 0 : 1)) / 2;

        // Determine how many single steps are in the current route
        int ones = evenNSteps ? 0 : 1;

        for (int i = leastSteps; i < n; i++)
        {
            // We're dealing with a permutation of a multiset which can be solved
            // using the formula n!/a!*b!
            // n is the total steps of the current iteration
            // a is the number of single steps
            // b is the number of double steps
            routes = routes.add(
                factorials[i].divide(
                    factorials[ones].multiply(factorials[i-ones])
                )
            );

            // Add 2 to the number of ones in the next iteration
            // Increasing the length of step sequence means we break down one two into two ones
            ones += 2;
        }

        return routes.intValue();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(Integer.parseInt(args[0])));
    }
}
