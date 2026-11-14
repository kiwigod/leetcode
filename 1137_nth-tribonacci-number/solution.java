/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 *
 * Constraints:
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
class Solution {
    // cache for future iteration lookup
    private int[] tn = new int[38];
    {
        tn[0] = 0;
        tn[1] = 1;
        tn[2] = 1;
    }

    public int tribonacci(int n) {
        if (n < 3) return tn[n];
        if (tn[n] == 0) {
            return tn[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        }

        return tn[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tribonacci(Integer.parseInt(args[0])));
    }
}
