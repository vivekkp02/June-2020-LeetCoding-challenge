/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n =  nums.length;
        List<Integer> result = new ArrayList<>();
        
        if(n==0)
            return result;
        
        int[] next_index = new int[n];
        int[] sizes = new int[n];
        Arrays.fill(next_index, -1);
        Arrays.fill(sizes, 1);
        
        int max_len = 1;
        int max_index = 0;
        
        Arrays.sort(nums);
        for(int i=n-1; i>=0; i--){
            int j = i + 1;
            int current_max = 0; 
            int current_max_index = i;
            
            while(j < n){
                if(nums[j] % nums[i] == 0 && sizes[j] > current_max){
                    current_max = sizes[j];
                    current_max_index = j;
                }
                j++;
            }
            
            if(current_max_index != i){
                sizes[i] += sizes[current_max_index];
                next_index[i] = current_max_index;
                if(current_max + 1 > max_len){
                    max_len = current_max + 1;
                    max_index = i;
                }
            }
        }
        
        int curr = max_index;
        while(curr >= 0){
            result.add(nums[curr]);
            curr = next_index[curr];
        }
        return result;
    }
}
