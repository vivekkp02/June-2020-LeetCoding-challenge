/*
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true 
Explanation: 20 = 1

Example 2:
Input: 16
Output: true
Explanation: 24 = 16

Example 3:
Input: 218
Output: false

Solution Approach:
==================
If n is the power of two:
n = 2 ^ 0 = 1 = 0b0000...00000001, and (n - 1) = 0 = 0b0000...0000.
n = 2 ^ 1 = 2 = 0b0000...00000010, and (n - 1) = 1 = 0b0000...0001.
n = 2 ^ 2 = 4 = 0b0000...00000100, and (n - 1) = 3 = 0b0000...0011.
n = 2 ^ 3 = 8 = 0b0000...00001000, and (n - 1) = 7 = 0b0000...0111.
we have n & (n-1) == 0b0000...0000 == 0
Otherwise, n & (n-1) != 0.       
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
       /*
        if (n <= 0) 
            return false;
        while (n%2 == 0) 
            n/=2;
        return n == 1;
        */
        
      //  return n>0 && (n==1 || (n%2==0 && (isPowerOfTwo(n/2))));
             
        return n > 0 && ((n & (n-1)) == 0);        
    }
}
