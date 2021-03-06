/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3

Example 2:
Input: [0,1,0,1,0,1,99]
Output: 99
*/

class Solution {
    public int singleNumber(int[] nums) {
        
        int[] bits = new int[32];
        
        for(int i=0; i<32; i++){
            for(int n : nums){
                bits[i] += (n >> i) & 1;
                bits[i] %= 3;
            }
        }
        
        int result = 0;
        // constructing result
        for(int i=0; i<32; i++)
            result |= bits[i] << i;
        
        return result;        
    }
    
    /*
               1010 <-  1010        1010        1010
               1010     1010 <-     1010        1010
               1101     1101        1101 <-     1101
               1010     1010        1010        1010 <-
    
    ones ::    1010 |   0000    |   0101    |   1101
    twice ::   0000 |   1010    |   0010    |   
    we reset to 0 if count is 3  
    
    */    
    public int singleNumber(int[] nums) {
        int ones = 0, twice = 0, thrice = 0;
        for(int n : nums){
            twice = twice | (ones & n);
            ones = ones ^ n;
            thrice = ones & twice;
            twice &= ~thrice;
            ones &= ~thrice;
        }
        return ones;        
    }
}
