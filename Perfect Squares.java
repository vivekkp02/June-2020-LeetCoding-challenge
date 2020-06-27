/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/
class Solution {
    public int numSquares(int n) {
        // bottom approach
        // if n = 1, then (1) -> 1
        // if n = 2, then (1,1) -> dp[1]+dp[1] -> 2
        // if n = 3, then (1,1,1)
        int[] dp = new int[n+1];
        for(int x=1; x<=n; x++){
            int y = 1; // take all 1s
            int sq = 1;
            int minVal = x;
            while(sq <= x){
                minVal = Math.min(minVal, 1+dp[x-sq]);
                y++;
                sq = y*y;
            }
            dp[x] = minVal;
        }
        return dp[n];
    }
}
