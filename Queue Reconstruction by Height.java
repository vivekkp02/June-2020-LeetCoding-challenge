/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
Note:
The number of people is less than 1,100.
 
Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

Solution Approch
================
Sort based on height and K value.
[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

Now we construct the queue using the sorted person list .

1. Add [7, 0] at 0 --> [[7,0]]
2. Add [7, 1] at 1 --> [[7,0], [7,1]]
3. Add [6, 1] at 1 --> [[7,0], [6, 1, [7,1]]
4. Add  [5,0] at 0 --> [[5,0], [7,0], [6, 1], [7,1]]
5. Add [5, 2] at 2 --> [[5,0], [7,0], [5, 2], [6, 1], [7,1]]
6. Add [4, 4] at 4 --> [[5,0], [7,0], [5, 2], [6, 1],[4, 4], [7,1]] which is output
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        // sort in descending order as per height
        // if height same, then in ascending order of k
        Arrays.sort(people, (a, b) -> {
            return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        });
        // then insert into result as per value of k
        for(int[] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }
}
