import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
class Solution {
    public int rob(int[] nums) {
        int i = nums.length;
        /**
         * These are our base cases
         * b1 - there are no houses to rob
         * b2 - rob the last (and possibly only) house
         */
        int b1 = 0;
        int b2 = nums[--i];

        /**
         * b1 is the best total from j+2 onward
         * b2 is the best total from j+1 onward
         * Therefore two adjacent houses can never be picked
         */
        for (int j = --i; j >= 0; j--)
        {
            int n = Math.max(
                b2,             // skip
                b1 + nums[j]    // rob
            );
            // shift the window
            b1 = b2;
            b2 = n;
        }

        return b2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(Arrays.stream(args).mapToInt(Integer::parseInt).toArray()));
    }
}
