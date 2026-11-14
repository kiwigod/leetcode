# 746 . Minimum Cost Climbing Stairs

# DP Solution
This is a dynamic programming solution where I build a "total cost from every step to the top" array.
- Each step has a minimum cost of 0
- Take the last two costs as base case
  - Exit the stairs from the last step with 1 step
  - Exit the stairs from the one to last step with 2 steps
    - cost[N-2] + cost[N-1] >= cost[N-2]
  - Therefore these cases are valid
Minimum cost of any step N below the base case can now be calculated.
- Valid moves from step N are N+1 or N+2
- Exiting the stairs with minimal costs is min(cost[n] + path_cost)
  - path_cost via N+1 is dp[N+1]
  - path_cost via N+2 is dp[N+2]
The minimum cost to climb the stairs must therefore be min(dp[0], dp[1])

# Solution
This solution is derived from the DP solution. From that solution's proof we can determine that we only need N+1 and
N+2 path cost at each step N. Therefore we can store them in plain integers, rather than storing the minimum exit cost for each step.
This reduces space complexity from O(n) to O(1).
